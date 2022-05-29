package com.example.compterendu.controller;

import com.example.compterendu.entity.Ticket;
import com.example.compterendu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("/")
    public int createTicket(@RequestBody Ticket ticket) {
        return clientService.createTicket(ticket);
    }
    @GetMapping("/ref/{ref}")
    public List<Ticket> ticketDeClient(@PathVariable String ref) {
        return clientService.ticketDeClient(ref);
    }
}
