package com.example.compterendu.service.impl;

import com.example.compterendu.entity.Devellopeur;
import com.example.compterendu.entity.Ticket;
import com.example.compterendu.service.AdminService;
import com.example.compterendu.service.DevellopeurService;
import com.example.compterendu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    private TicketService ticketService;
    private DevellopeurService devellopeurService;

    @Autowired
    public AdminServiceImpl(TicketService ticketService, DevellopeurService devellopeurService) {
        this.ticketService = ticketService;
        this.devellopeurService = devellopeurService;
    }

    @Override
    public int affecterTicket(Ticket ticket, String refDev) {
        Devellopeur devellopeur= devellopeurService.findByRef(refDev);
        Ticket ticket1=ticketService.findByRef(ticket.getRef());
        if(devellopeur!=null){
            devellopeur.getTicket().add(ticket1);
            devellopeur.setTicket(devellopeur.getTicket());
            devellopeurService.save(devellopeur);
            return 1;
        }
        return -2;
    }

    @Override
    public List<Ticket> nonAttribue() {
        return ticketService.nonAttribuee();
    }
}
