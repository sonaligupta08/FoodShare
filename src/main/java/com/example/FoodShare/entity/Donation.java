package com.example.FoodShare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodDescription;
    private String address;
    private String landmark;
    private String imageUrl;

    private Long donorId;
    private String donorEmail;
    private String donorMobile;

    private Long takenBy;
    private boolean taken = false;

    // 🧩 Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodDescription() {
        return foodDescription;
    }
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getDonorId() {
        return donorId;
    }
    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public String getDonorEmail() {
        return donorEmail;
    }
    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorMobile() {
        return donorMobile;
    }
    public void setDonorMobile(String donorMobile) {
        this.donorMobile = donorMobile;
    }

    public Long getTakenBy() {
        return takenBy;
    }
    public void setTakenBy(Long takenBy) {
        this.takenBy = takenBy;
    }

    public boolean isTaken() {
        return taken;
    }
    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
