package com.qtvsmart.qtvsmartServer.controller;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Role;
import com.qtvsmart.qtvsmartServer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/addRole/{idAccount}")
    public String addRoletoAccount(@RequestBody Role role, @PathVariable("idAccount") int idAccount) {
        int idRole = Math.toIntExact(role.getId());
        accountService.addRoletoAccount(idRole, idAccount);
        return "success";
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable("id") int id) {
        return accountService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Account> getAll() {
        return accountService.getAll();
    }
}
