package com.example.compterendu.service;

import com.example.compterendu.entity.Ticket;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketService{
    Ticket findByRef(String ref);
    List<Ticket> findByRoleRef(String ref);
    List<Ticket> findAll();
    List<Ticket>nonAttribuee();

    int save(Ticket ticket);
    int update(Ticket ticket);
}
