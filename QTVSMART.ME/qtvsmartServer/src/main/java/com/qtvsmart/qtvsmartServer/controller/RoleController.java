package com.qtvsmart.qtvsmartServer.controller;

import com.qtvsmart.qtvsmartServer.entity.Role;
import com.qtvsmart.qtvsmartServer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public String createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/getAll")
    public List<Role> getAllRole() {
        return roleService.getAll();
    }
}
