package com.example.compterendu.repository;

import com.example.compterendu.entity.Devellopeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevellopeurRepository extends JpaRepository<Devellopeur,Long> {
    Devellopeur findByRef(String ref);
    List<Devellopeur> findAll();
}
