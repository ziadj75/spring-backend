package com.example.compterendu.service.impl;

import com.example.compterendu.entity.Devellopeur;
import com.example.compterendu.entity.Role;
import com.example.compterendu.entity.Ticket;
import com.example.compterendu.repository.DevellopeurRepository;
import com.example.compterendu.service.DevellopeurService;
import com.example.compterendu.service.RoleService;
import com.example.compterendu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevellopeurServiceImpl implements DevellopeurService {

    private TicketService ticketService;
    private RoleService roleService;
    private DevellopeurRepository devellopeurRepository;
    @Autowired
    public DevellopeurServiceImpl(TicketService ticketService,RoleService roleService,DevellopeurRepository devellopeurRepository) {
        this.ticketService = ticketService;
        this.roleService = roleService;
        this.devellopeurRepository = devellopeurRepository;
    }

    @Override
    public Devellopeur ticketDeDev(String ref) {
        System.out.println(ref);
        return devellopeurRepository.findByRef("developpeur");
    }

    @Override
    public int updateTicket(Ticket ticket) {
        Role role= roleService.findByRef("developpeur");
        ticket.setRole(role);
        return ticketService.update(ticket);
    }
    @Override
    public int save(Devellopeur devellopeur){
         devellopeurRepository.save(devellopeur);
         return 1;
    }
    @Override
    public Devellopeur findByRef(String ref) {
        return devellopeurRepository.findByRef(ref);
    }

    @Override
    public List<Devellopeur> findAll() {
        return devellopeurRepository.findAll();
    }
}
