package com.qtvsmart.qtvsmartServer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "statusProduct")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean enable;

    private boolean statusSale;

    private String statusProduct;
    
    private int views;

    @OneToMany(mappedBy = "statusProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

}
