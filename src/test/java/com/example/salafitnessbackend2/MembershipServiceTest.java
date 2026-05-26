package com.example.salafitnessbackend2;

import com.example.salafitnessbackend2.model.Member;
import com.example.salafitnessbackend2.model.Membership;
import com.example.salafitnessbackend2.repository.MembershipRepository;
import com.example.salafitnessbackend2.service.MembershipService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MembershipServiceTest {

    @Test
    void testGetAllMemberships() {
        MembershipRepository repository = Mockito.mock(MembershipRepository.class);
        MembershipService service = new MembershipService(repository);

        Membership membership = new Membership();
        membership.setPrice(150.0);

        when(repository.findAll()).thenReturn(List.of(membership));

        List<Membership> result = service.getAllMemberships();

        assertEquals(1, result.size());
        assertEquals(150.0, result.get(0).getPrice());
    }

    @Test
    void testAddMembership() {
        MembershipRepository repository = Mockito.mock(MembershipRepository.class);
        MembershipService service = new MembershipService(repository);

        Membership membership = new Membership();
        membership.setPrice(100.0);

        when(repository.save(membership)).thenReturn(membership);

        Membership result = service.addMembership(membership);

        assertEquals(100.0, result.getPrice());
    }

    @Test
    void testMembershipHasMember() {
        Membership membership = new Membership();
        Member member = new Member();
        member.setFirstName("Ana");

        membership.setMember(member);
        membership.setStartDate(LocalDate.of(2026, 4, 1));
        membership.setEndDate(LocalDate.of(2026, 5, 1));

        assertEquals("Ana", membership.getMember().getFirstName());
        assertEquals(LocalDate.of(2026, 4, 1), membership.getStartDate());
    }
}