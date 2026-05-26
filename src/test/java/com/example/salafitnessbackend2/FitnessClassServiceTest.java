package com.example.salafitnessbackend2;

import com.example.salafitnessbackend2.model.FitnessClass;
import com.example.salafitnessbackend2.model.Trainer;
import com.example.salafitnessbackend2.repository.FitnessClassRepository;
import com.example.salafitnessbackend2.service.FitnessClassService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FitnessClassServiceTest {

    @Test
    void testGetAllClasses() {
        FitnessClassRepository repository = Mockito.mock(FitnessClassRepository.class);
        FitnessClassService service = new FitnessClassService(repository);

        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setClassName("Yoga");

        when(repository.findAll()).thenReturn(List.of(fitnessClass));

        List<FitnessClass> result = service.getAllClasses();

        assertEquals(1, result.size());
        assertEquals("Yoga", result.get(0).getClassName());
    }

    @Test
    void testAddClass() {
        FitnessClassRepository repository = Mockito.mock(FitnessClassRepository.class);
        FitnessClassService service = new FitnessClassService(repository);

        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setClassName("Cardio");

        when(repository.save(fitnessClass)).thenReturn(fitnessClass);

        FitnessClass result = service.addClass(fitnessClass);

        assertEquals("Cardio", result.getClassName());
    }

    @Test
    void testClassHasTrainer() {
        FitnessClass fitnessClass = new FitnessClass();
        Trainer trainer = new Trainer();
        trainer.setFirstName("Maria");

        fitnessClass.setTrainer(trainer);

        assertEquals("Maria", fitnessClass.getTrainer().getFirstName());
    }
}