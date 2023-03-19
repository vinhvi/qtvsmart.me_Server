package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Role;

import java.util.List;

public interface RoleService {
    String createRole(Role role);
    List<Role> getAll();

    Role getOneRole(Role role);

}
