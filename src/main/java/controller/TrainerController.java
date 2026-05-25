package com.example.salafitnessbackend2.controller;

import com.example.salafitnessbackend2.model.Trainer;
import com.example.salafitnessbackend2.service.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody Trainer updatedTrainer) {
        return trainerService.updateTrainer(id, updatedTrainer);
    }

    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return "Antrenorul cu id-ul " + id + " a fost sters.";
    }
}