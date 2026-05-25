package com.example.salafitnessbackend2.repository;

import com.example.salafitnessbackend2.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}