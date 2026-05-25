package com.example.salafitnessbackend2.controller;

import com.example.salafitnessbackend2.model.FitnessClass;
import com.example.salafitnessbackend2.service.FitnessClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class FitnessClassController {

    private final FitnessClassService fitnessClassService;

    public FitnessClassController(FitnessClassService fitnessClassService) {
        this.fitnessClassService = fitnessClassService;
    }

    @GetMapping
    public List<FitnessClass> getAllClasses() {
        return fitnessClassService.getAllClasses();
    }

    @PostMapping
    public FitnessClass addClass(@RequestBody FitnessClass fitnessClass) {
        return fitnessClassService.addClass(fitnessClass);
    }

    @PutMapping("/{id}")
    public FitnessClass updateClass(@PathVariable Long id, @RequestBody FitnessClass updatedClass) {
        return fitnessClassService.updateClass(id, updatedClass);
    }

    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id) {
        fitnessClassService.deleteClass(id);
        return "Clasa fitness cu id-ul " + id + " a fost stearsa.";
    }
}