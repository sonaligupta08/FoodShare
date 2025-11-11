package com.example.FoodShare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodShare.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{

}
