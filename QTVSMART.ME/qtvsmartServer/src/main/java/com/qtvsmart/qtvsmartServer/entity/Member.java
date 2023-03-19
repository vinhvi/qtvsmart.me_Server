package com.qtvsmart.qtvsmartServer.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends Person {
    @Column(nullable = false, unique = true)
    private String address;

    private int score;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

}
