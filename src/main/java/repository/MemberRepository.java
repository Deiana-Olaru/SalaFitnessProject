package com.example.salafitnessbackend2.repository;

import com.example.salafitnessbackend2.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}