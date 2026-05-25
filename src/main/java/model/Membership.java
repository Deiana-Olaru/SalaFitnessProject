package com.example.salafitnessbackend2.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Membership() {
    }

    public Membership(LocalDate startDate, LocalDate endDate, Double price, Member member) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}