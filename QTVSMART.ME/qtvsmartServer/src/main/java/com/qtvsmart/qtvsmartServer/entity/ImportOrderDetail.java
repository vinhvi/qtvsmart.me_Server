package com.qtvsmart.qtvsmartServer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "importOrderDetail")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "importOrder_id")
    private ImportOrder importOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    private Product product;
    private int count;

    private float price;


}
