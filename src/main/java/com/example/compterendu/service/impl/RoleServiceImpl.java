package com.example.compterendu.service.impl;

import com.example.compterendu.entity.Role;
import com.example.compterendu.repository.RoleRepository;
import com.example.compterendu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role signin(String username, String password) {
        return repository.findByLoginAndPassword(username, password);
    }

    @Override
    public int signup(Role role) {
        repository.save(role);
        return 1;
    }

    @Override
    public Role findByRef(String ref) {
        return repository.findByRef(ref);
    }
}
