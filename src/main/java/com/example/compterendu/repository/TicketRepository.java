package com.example.compterendu.repository;

import com.example.compterendu.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findByRef(String ref);
    List<Ticket> findByRoleRef(String ref);
    List<Ticket> findAll();
    @Query("select c from Ticket c where c.id not in (:ticketsDev)  ")
    List<Ticket>nonAttribuee(@Param("ticketsDev")List<Long> tickets);

}
