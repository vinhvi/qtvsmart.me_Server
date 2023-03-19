package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Account;

import java.util.List;

public interface AccountService {
    void addRoletoAccount(int idRole, int idAccount);
    Account getById(int id);

    Account getOne(Account account);

    List<Account> getAll();
}
