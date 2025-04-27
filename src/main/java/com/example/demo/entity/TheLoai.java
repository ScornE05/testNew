package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TheLoai")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTL")
    private Integer maTL;

    @Column(name = "MaTheLoai", length = 10, nullable = false, unique = true)
    private String maTheLoai;

    @Column(name = "TenTheLoai", length = 100, nullable = false)
    private String tenTheLoai;

    @Column(name = "MoTa", length = 500)
    private String moTa;
}