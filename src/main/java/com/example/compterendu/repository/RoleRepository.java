package com.example.compterendu.repository;

import com.example.compterendu.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRef(String ref);
    Role findByLoginAndPassword(String username,String password);

}
