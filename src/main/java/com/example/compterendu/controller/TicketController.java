package com.example.compterendu.controller;

import com.example.compterendu.entity.Ticket;
import com.example.compterendu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @GetMapping("/ref/{ref}")
    public Ticket findByRef(@PathVariable String ref) {
        return ticketService.findByRef(ref);
    }
    @GetMapping("/refrole/{ref}")
    public List<Ticket> findByRoleRef(@PathVariable String ref) {
        return ticketService.findByRoleRef(ref);
    }
    @GetMapping("/")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }
    @GetMapping("nonattribuee/")
    public List<Ticket> nonAttribuee() {
        return ticketService.nonAttribuee();
    }
    @PostMapping("/")
    public int save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }
    @PutMapping("/")
    public int update(@RequestBody Ticket ticket) {
        return ticketService.update(ticket);
    }
}
