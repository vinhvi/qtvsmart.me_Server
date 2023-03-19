package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Role;
import com.qtvsmart.qtvsmartServer.repository.RoleRepository;
import com.qtvsmart.qtvsmartServer.service.AccountService;
import com.qtvsmart.qtvsmartServer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public String createRole(Role role) {
        roleRepository.save(role);
        return "success";
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getOneRole(Role role) {
        Role role1 = new Role();
        role1.setId(role.getId());
        role1.setName(role.getName());
        Account account = new Account();
        Set<Account> accounts = role.getAccounts();
        Set<Account> accounts1 = new HashSet<>();
        Account[] accountList = accounts.toArray(new Account[0]);
        for (Account account1 : accountList) {
            account.setId(account1.getId());
            account.setEmail(account1.getEmail());
            account.setPassword(account1.getPassword());
            account.setEnable(account1.getEnable());
            accounts1.add(account);
        }
        role1.setAccounts(accounts1);

        return role1;
    }
}
