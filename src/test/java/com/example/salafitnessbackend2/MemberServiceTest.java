package com.example.salafitnessbackend2;

import com.example.salafitnessbackend2.model.Member;
import com.example.salafitnessbackend2.repository.MemberRepository;
import com.example.salafitnessbackend2.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MemberServiceTest {

    @Test
    void testGetAllMembers() {
        MemberRepository repository = Mockito.mock(MemberRepository.class);
        MemberService service = new MemberService(repository);

        Member member = new Member();
        member.setFirstName("Ana");
        member.setLastName("Dumitrescu");

        when(repository.findAll()).thenReturn(List.of(member));

        List<Member> result = service.getAllMembers();

        assertEquals(1, result.size());
        assertEquals("Ana", result.get(0).getFirstName());
    }

    @Test
    void testAddMember() {
        MemberRepository repository = Mockito.mock(MemberRepository.class);
        MemberService service = new MemberService(repository);

        Member member = new Member();
        member.setFirstName("Mihai");

        when(repository.save(member)).thenReturn(member);

        Member result = service.addMember(member);

        assertEquals("Mihai", result.getFirstName());
        verify(repository, times(1)).save(member);
    }

    @Test
    void testUpdateMember() {
        MemberRepository repository = Mockito.mock(MemberRepository.class);
        MemberService service = new MemberService(repository);

        Member existingMember = new Member();
        existingMember.setFirstName("Ana");

        Member updatedMember = new Member();
        updatedMember.setFirstName("Elena");
        updatedMember.setLastName("Olaru");
        updatedMember.setPhone("0712345678");
        updatedMember.setEmail("elena@email.com");
        updatedMember.setMembershipType("Premium");

        when(repository.findById(1L)).thenReturn(Optional.of(existingMember));
        when(repository.save(existingMember)).thenReturn(existingMember);

        Member result = service.updateMember(1L, updatedMember);

        assertEquals("Elena", result.getFirstName());
        assertEquals("Olaru", result.getLastName());
    }
}