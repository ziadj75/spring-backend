package com.example.compterendu.service;

import com.example.compterendu.entity.Devellopeur;
import com.example.compterendu.entity.Ticket;

import java.util.List;

public interface DevellopeurService {
    Devellopeur ticketDeDev(String ref);
    int updateTicket(Ticket ticket);
    Devellopeur findByRef(String ref);
    int save(Devellopeur devellopeur);

    List<Devellopeur> findAll();
}
