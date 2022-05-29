package com.example.compterendu.service;

import com.example.compterendu.entity.Ticket;

import java.util.List;

public interface ClientService {
     int createTicket(Ticket ticket);
     List<Ticket> ticketDeClient(String ref);
}
