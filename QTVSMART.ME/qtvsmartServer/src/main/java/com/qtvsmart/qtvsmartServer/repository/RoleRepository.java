package com.qtvsmart.qtvsmartServer.repository;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findRoleById(int id);
}
