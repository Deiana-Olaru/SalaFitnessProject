package com.example.salafitnessbackend2.service;

import com.example.salafitnessbackend2.model.Member;
import com.example.salafitnessbackend2.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Member member = memberRepository.findById(id).orElseThrow();

        member.setFirstName(updatedMember.getFirstName());
        member.setLastName(updatedMember.getLastName());
        member.setPhone(updatedMember.getPhone());
        member.setEmail(updatedMember.getEmail());
        member.setMembershipType(updatedMember.getMembershipType());

        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}