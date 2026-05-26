package com.example.salafitnessbackend2;

import com.example.salafitnessbackend2.model.Trainer;
import com.example.salafitnessbackend2.repository.TrainerRepository;
import com.example.salafitnessbackend2.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrainerServiceTest {

    @Test
    void testGetAllTrainers() {
        TrainerRepository repository = Mockito.mock(TrainerRepository.class);
        TrainerService service = new TrainerService(repository);

        Trainer trainer = new Trainer();
        trainer.setFirstName("Maria");

        when(repository.findAll()).thenReturn(List.of(trainer));

        List<Trainer> result = service.getAllTrainers();

        assertEquals(1, result.size());
        assertEquals("Maria", result.get(0).getFirstName());
    }

    @Test
    void testAddTrainer() {
        TrainerRepository repository = Mockito.mock(TrainerRepository.class);
        TrainerService service = new TrainerService(repository);

        Trainer trainer = new Trainer();
        trainer.setFirstName("Andrei");

        when(repository.save(trainer)).thenReturn(trainer);

        Trainer result = service.addTrainer(trainer);

        assertEquals("Andrei", result.getFirstName());
    }

    @Test
    void testTrainerSpecialization() {
        Trainer trainer = new Trainer();

        trainer.setSpecialization("Fitness");

        assertEquals("Fitness", trainer.getSpecialization());
    }
}