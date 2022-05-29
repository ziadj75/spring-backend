package com.example.compterendu.service;

import com.example.compterendu.entity.Role;

public interface RoleService {
    Role signin(String username,String password);
    int signup(Role role);

    Role findByRef(String ref);
}
