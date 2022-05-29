package com.example.compterendu.service.impl;

import com.example.compterendu.entity.Devellopeur;
import com.example.compterendu.entity.Role;
import com.example.compterendu.entity.Ticket;
import com.example.compterendu.repository.DevellopeurRepository;
import com.example.compterendu.repository.TicketRepository;
import com.example.compterendu.service.DevellopeurService;
import com.example.compterendu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private DevellopeurRepository devellopeurRepository;

    @Override
    public Ticket findByRef(String ref) {
        return ticketRepository.findByRef(ref);
    }

    @Override
    public List<Ticket> findByRoleRef(String ref) {
        return ticketRepository.findByRoleRef(ref);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> nonAttribuee() {
        List<Devellopeur> devellopeurs =devellopeurRepository.findAll();
        List<Long> tickets=new ArrayList<>();
        for (Devellopeur devellopeur:devellopeurs) {
            for (Ticket tickete:devellopeur.getTicket()) {
                tickets.add(tickete.getId());
            }
        }
        System.out.println(tickets);
        if(tickets.isEmpty()){
            tickets.add(-1L);
        }

        return ticketRepository.nonAttribuee(tickets);
    }

    @Override
    public int save(Ticket ticket) {
        Ticket ticketSearch=findByRef(ticket.getRef());
        if(ticketSearch==null){
            ticketRepository.save(ticket);
            return 1;
        }
        return -2;
    }

    @Override
    public int update(Ticket ticket) {
        Ticket ticketSearch=findByRef(ticket.getRef());
        if(ticketSearch!=null){
            ticketSearch.setDescription(ticket.getDescription());
            ticketSearch.setEnvironement(ticket.getEnvironement());
            ticketSearch.setEtatTache(ticket.getEtatTache());
            ticketSearch.setRole(ticket.getRole());
            ticketSearch.setUrgence(ticket.getUrgence());
            ticketRepository.save(ticketSearch);
            return 1;
        }

        return -2;
    }
}
