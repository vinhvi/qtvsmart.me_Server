package com.qtvsmart.qtvsmartServer.controller;

import com.qtvsmart.qtvsmartServer.entity.Member;
import com.qtvsmart.qtvsmartServer.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/addCustomer/{password}")
    public int addCustomer(@RequestBody Member member, @PathVariable("password") String password) {

        return memberService.addCustomer(member, password);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable("id") int id) {
        Member member = memberService.getCustomerById(id);
        if (member != null) {
            return ResponseEntity.ok().body(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getAll")
    public List<Member> getAll() {
        List<Member> members = memberService.getAll();
        if (members == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found");
        }
        return members;
    }

}
