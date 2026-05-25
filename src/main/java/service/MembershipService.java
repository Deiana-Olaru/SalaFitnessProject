package com.example.salafitnessbackend2.service;

import com.example.salafitnessbackend2.model.Membership;
import com.example.salafitnessbackend2.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public Membership addMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public Membership updateMembership(Long id, Membership updatedMembership) {

        Membership membership = membershipRepository.findById(id).orElseThrow();

        membership.setStartDate(updatedMembership.getStartDate());
        membership.setEndDate(updatedMembership.getEndDate());
        membership.setPrice(updatedMembership.getPrice());
        membership.setMember(updatedMembership.getMember());

        return membershipRepository.save(membership);
    }

    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }
}