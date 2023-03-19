package com.qtvsmart.qtvsmartServer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currentCustomer")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentCustomer extends Person {

    @Column(nullable = false, unique = true)
    private String address;

    @OneToMany(mappedBy = "currentCustomer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();


}
