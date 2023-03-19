package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Member;
import com.qtvsmart.qtvsmartServer.repository.AccountRepository;
import com.qtvsmart.qtvsmartServer.repository.MemberRepository;
import com.qtvsmart.qtvsmartServer.service.AccountService;
import com.qtvsmart.qtvsmartServer.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;


    @Override
    public int addCustomer(Member member, String password) {
        Account account = new Account();
        account.setEmail(member.getEmail());
        account.setPassword(password);
        account.setEnable(true);

        accountRepository.save(account);

        Member member1 = new Member();
        member1.setName(member.getName());
        member1.setScore(member.getScore());
        member1.setEmail(member.getEmail());
        member1.setAddress(member.getAddress());
        member1.setPhone(member.getPhone());
        member1.setSex(member.getSex());
        member1.setNgaySinh(member.getNgaySinh());
        member1.setAccount(account);

        memberRepository.save(member1);

        return account.getId();
    }

    @Override
    public Member getCustomerById(int id) {
        Member member = memberRepository.findCustomerById(id);
        Member member1 = getOne(member);
        return member1;

    }

    @Override
    public List<Member> getAll() {
        List<Member> members = memberRepository.findAll();
        List<Member> customers1 = new ArrayList<>();
        Member member1;
        for (Member member : members) {
            member1 = getOne(member);
            customers1.add(member1);
        }
        return customers1;
    }

    @Override
    public Member getOne(Member member) {
        Member memberSet = new Member();
        Account account = accountService.getOne(member.getAccount());
        memberSet.setId(member.getId());
        memberSet.setEmail(member.getEmail());
        memberSet.setName(member.getName());
        memberSet.setSex(member.getSex());
        memberSet.setAddress(member.getAddress());
        memberSet.setNgaySinh(member.getNgaySinh());
        memberSet.setScore(member.getScore());
        memberSet.setAccount(account);
        return memberSet;
    }


}
