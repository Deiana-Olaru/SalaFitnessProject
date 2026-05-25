package com.example.salafitnessbackend2.service;

import com.example.salafitnessbackend2.model.FitnessClass;
import com.example.salafitnessbackend2.repository.FitnessClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessClassService {

    private final FitnessClassRepository fitnessClassRepository;

    public FitnessClassService(FitnessClassRepository fitnessClassRepository) {
        this.fitnessClassRepository = fitnessClassRepository;
    }

    public List<FitnessClass> getAllClasses() {
        return fitnessClassRepository.findAll();
    }

    public FitnessClass addClass(FitnessClass fitnessClass) {
        return fitnessClassRepository.save(fitnessClass);
    }

    public FitnessClass updateClass(Long id, FitnessClass updatedClass) {
        FitnessClass fitnessClass = fitnessClassRepository.findById(id).orElseThrow();

        fitnessClass.setClassName(updatedClass.getClassName());
        fitnessClass.setSchedule(updatedClass.getSchedule());
        fitnessClass.setTrainer(updatedClass.getTrainer());

        return fitnessClassRepository.save(fitnessClass);
    }

    public void deleteClass(Long id) {
        fitnessClassRepository.deleteById(id);
    }
}