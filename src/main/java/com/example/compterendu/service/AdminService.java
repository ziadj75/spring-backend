package com.example.compterendu.service;

import com.example.compterendu.entity.Admin;
import com.example.compterendu.entity.Ticket;

import java.util.List;

public interface AdminService {
    int affecterTicket(Ticket ticket,String refDev);
    List<Ticket>nonAttribue();
}
