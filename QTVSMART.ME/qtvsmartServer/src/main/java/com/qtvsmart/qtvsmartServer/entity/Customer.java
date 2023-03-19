package com.qtvsmart.qtvsmartServer.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person {
    @Column(nullable = false, unique = true)
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

}
