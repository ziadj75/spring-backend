package com.example.compterendu.controller;

import com.example.compterendu.entity.Ticket;
import com.example.compterendu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/refDev/{refDev}")
    public int affecterTicket(@RequestBody Ticket ticket,@PathVariable String refDev) {
        return adminService.affecterTicket(ticket, refDev);
    }
    @GetMapping("/")
    public List<Ticket> nonAttribue() {
        return adminService.nonAttribue();
    }
}
