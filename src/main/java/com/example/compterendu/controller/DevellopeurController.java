package com.example.compterendu.controller;

import com.example.compterendu.entity.Devellopeur;
import com.example.compterendu.entity.Ticket;
import com.example.compterendu.service.DevellopeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/devellopeur")
public class DevellopeurController {
    @Autowired
    private DevellopeurService devellopeurService;
    @GetMapping("/refdev/{ref}")
    public Devellopeur ticketDeDev(@PathVariable String ref) {
        return devellopeurService.ticketDeDev(ref);
    }
    @PutMapping("/")
    public int updateTicket(@RequestBody Ticket ticket) {
        return devellopeurService.updateTicket(ticket);
    }
    @GetMapping("/ref/{ref}")
    public Devellopeur findByRef(@PathVariable String ref) {
        return devellopeurService.findByRef(ref);
    }
    @GetMapping("/")
    public List<Devellopeur>findAll(){
        return devellopeurService.findAll();
    }
}
