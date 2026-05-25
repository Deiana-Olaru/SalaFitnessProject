package com.example.salafitnessbackend2.controller;

import com.example.salafitnessbackend2.model.Membership;
import com.example.salafitnessbackend2.service.MembershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @PostMapping
    public Membership addMembership(@RequestBody Membership membership) {
        return membershipService.addMembership(membership);
    }

    @PutMapping("/{id}")
    public Membership updateMembership(@PathVariable Long id, @RequestBody Membership updatedMembership) {
        return membershipService.updateMembership(id, updatedMembership);
    }

    @DeleteMapping("/{id}")
    public String deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return "Abonamentul cu id-ul " + id + " a fost sters.";
    }
}