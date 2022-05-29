package com.example.compterendu.controller;

import com.example.compterendu.entity.Role;
import com.example.compterendu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/username/{username}/password/{password}")
    public Role signin(@PathVariable String username,@PathVariable String password) {
        return roleService.signin(username, password);
    }
    @PostMapping("/")
    public int signup(@RequestBody Role role) {
        return roleService.signup(role);
    }
    @GetMapping("/ref/{ref}")
    public Role findByRef(@PathVariable String ref) {
        return roleService.findByRef(ref);
    }
}
