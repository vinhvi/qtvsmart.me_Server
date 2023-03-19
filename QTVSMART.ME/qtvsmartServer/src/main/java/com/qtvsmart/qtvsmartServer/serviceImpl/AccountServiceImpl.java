package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Role;
import com.qtvsmart.qtvsmartServer.repository.AccountRepository;
import com.qtvsmart.qtvsmartServer.repository.RoleRepository;
import com.qtvsmart.qtvsmartServer.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public void addRoletoAccount(int idRole, int idAccount) {
        Account account = accountRepository.findAccountById(idAccount);
        Role role = roleRepository.findRoleById(idRole);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        accountRepository.save(account);
    }

    @Override
    public Account getById(int id) {
        Account account = getOne(accountRepository.findAccountById(id));
        return account;
    }

    @Override
    public Account getOne(Account account) {
        Account account1 = new Account();
        account1.setId(account.getId());
        account1.setEmail(account.getEmail());
        account1.setPassword(account.getPassword());
        account1.setEnable(account.getEnable());
        Role role = new Role();
        Set<Role> roles = account.getRoles();
        Set<Role> roles1 = new HashSet<>();
        Role[] arr = roles.toArray(new Role[0]);
        for (int i = 0; i < arr.length; i++) {
            role.setId(arr[i].getId());
            role.setName(arr[i].getName());
            roles1.add(role);
        }
        account1.setRoles(roles1);
        return account1;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepository.findAll();
        List<Account> accounts1 = new ArrayList<>();
        Account account2 ;
        for (Account account : accounts) {
            account2 = getOne(account);
            accounts1.add(account2);
        }
        return accounts1;
    }


}
