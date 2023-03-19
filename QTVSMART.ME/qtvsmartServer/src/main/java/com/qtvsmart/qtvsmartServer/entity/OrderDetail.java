package com.qtvsmart.qtvsmartServer.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "orderDetail")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    private int quantity;

    private float unitPrice;
}
