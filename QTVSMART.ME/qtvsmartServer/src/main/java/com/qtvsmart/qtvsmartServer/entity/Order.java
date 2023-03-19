package com.qtvsmart.qtvsmartServer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Member member;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails= new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payments> payments = new ArrayList<>();

    private Date ngayDat;

    private String diaChiGiaoHang;

    private Date ngayGiao;

    private String notes;

    private boolean statusPayment;

    private boolean statusGH;



}
