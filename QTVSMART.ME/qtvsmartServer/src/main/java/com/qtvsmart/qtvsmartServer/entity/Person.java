package com.qtvsmart.qtvsmartServer.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@MappedSuperclass
@Data
@Getter
@Setter

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private Date ngaySinh;
    @Column(nullable = false, unique = true)
    private int sex;
    @Column(nullable = false, unique = true)

    private String phone;

}
