package com.example.salafitnessbackend2.repository;

import com.example.salafitnessbackend2.model.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long> {
}