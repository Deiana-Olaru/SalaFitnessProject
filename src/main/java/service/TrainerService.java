package com.example.salafitnessbackend2.service;

import com.example.salafitnessbackend2.model.Trainer;
import com.example.salafitnessbackend2.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer updatedTrainer) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow();

        trainer.setFirstName(updatedTrainer.getFirstName());
        trainer.setLastName(updatedTrainer.getLastName());
        trainer.setSpecialization(updatedTrainer.getSpecialization());
        trainer.setPhone(updatedTrainer.getPhone());

        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}