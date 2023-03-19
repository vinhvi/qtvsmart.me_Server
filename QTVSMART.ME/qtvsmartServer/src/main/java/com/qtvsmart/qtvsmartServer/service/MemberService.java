package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Member;

import java.util.List;

public interface MemberService {
    int addCustomer(Member member, String password);

    Member getCustomerById(int id);

    List<Member> getAll();

    Member getOne(Member member);

}
