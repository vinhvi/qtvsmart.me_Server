package com.qtvsmart.qtvsmartServer.repository;

import com.qtvsmart.qtvsmartServer.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findCustomerById(int id);
}
