package com.example.FoodShare.controller;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.FoodShare.entity.Donation;
import com.example.FoodShare.repository.DonationRepository;

@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "*")
public class DonationController {

    @Autowired
    private DonationRepository donationRepository;

    private static final String UPLOAD_DIR = "uploads/";

    // =========================
    // 1️⃣ Upload image endpoint
    // =========================
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty!");
            }

            Path uploadPath = Paths.get(UPLOAD_DIR);

            // Create upload directory if not exists
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Generate a unique file name
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);

            // Save the uploaded file
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String fileUrl = "http://localhost:8080/" + UPLOAD_DIR + fileName;
            return ResponseEntity.ok(fileUrl);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error uploading file: " + e.getMessage());
        }
    }

    // =========================
    // 2️⃣ Add new donation
    // =========================
    @PostMapping
    public ResponseEntity<Donation> addDonation(@RequestBody Donation donation) {
        Donation savedDonation = donationRepository.save(donation);
        return ResponseEntity.ok(savedDonation);
    }

    // =========================
    // 3️⃣ Get all donations
    // =========================
    @GetMapping
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = donationRepository.findAll();
        return ResponseEntity.ok(donations);
    }

    // =========================
    // 4️⃣ Delete donation (only donor can delete)
    // =========================
    @DeleteMapping("/{id}/{userId}")
    public ResponseEntity<String> deleteDonation(@PathVariable Long id, @PathVariable Long userId) {
        Donation donation = donationRepository.findById(id).orElse(null);

        if (donation == null) {
            return ResponseEntity.badRequest().body("Donation not found");
        }

        if (!donation.getDonorId().equals(userId)) {
            return ResponseEntity.status(403).body("Unauthorized: Only the creator can delete this donation");
        }

        donationRepository.delete(donation);
        return ResponseEntity.ok("Donation deleted successfully");
    }

    // =========================
    // 5️⃣ Take donation (mark as taken)
    // =========================
    @PutMapping("/take/{id}/{userId}")
    public ResponseEntity<String> takeDonation(@PathVariable Long id, @PathVariable Long userId) {
        Donation donation = donationRepository.findById(id).orElse(null);

        if (donation == null) {
            return ResponseEntity.badRequest().body("Donation not found");
        }

        if (donation.isTaken()) {
            return ResponseEntity.badRequest().body("This donation is already taken!");
        }

        donation.setTaken(true);
        donation.setTakenBy(userId);
        donationRepository.save(donation);

        // Optional: Return contact info of the donor
        // (Assuming Donation entity has donorEmail or donorPhone)
        String contactInfo = "";
        if (donation.getDonorEmail() != null) {
            contactInfo = "Contact donor via email: " + donation.getDonorEmail();
        } else if (donation.getDonorPhone() != null) {
            contactInfo = "Contact donor via phone: " + donation.getDonorPhone();
        } else {
            contactInfo = "Donation marked as taken! Contact info not available.";
        }

        return ResponseEntity.ok(contactInfo);
    }
}
