package com.example.compterendu.service.impl;

import com.example.compterendu.entity.Role;
import com.example.compterendu.entity.Ticket;
import com.example.compterendu.repository.ClientRepository;
import com.example.compterendu.service.ClientService;
import com.example.compterendu.service.RoleService;
import com.example.compterendu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private TicketService ticketService;
    private RoleService roleService;

    @Autowired
    public ClientServiceImpl(TicketService ticketService,RoleService roleService) {
        this.ticketService = ticketService;
        this.roleService = roleService;
    }

    @Override
    public int createTicket(Ticket ticket) {
        Role role=roleService.findByRef("client");
        ticket.setRole(role);
        ticket.setEtatTache("problème non résolu");
        ticketService.save(ticket);
        return 0;
    }

    @Override
    public List<Ticket> ticketDeClient(String ref) {
        return ticketService.findByRoleRef("client");
    }
}
