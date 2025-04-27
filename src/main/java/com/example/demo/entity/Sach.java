package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Sach")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSach")
    private Integer maSach;

    @Column(name = "MaCode", length = 20, nullable = false, unique = true)
    private String maCode;

    @Column(name = "TenSach", length = 200, nullable = false)
    private String tenSach;

    @Column(name = "TacGia", length = 100)
    private String tacGia;

    @Column(name = "NamXuatBan")
    private Integer namXuatBan;

    @ManyToOne
    @JoinColumn(name = "MaTL", nullable = false)
    private TheLoai theLoai;

    @Column(name = "SoLuong")
    private Integer soLuong = 0;

    @Column(name = "TrangThai", length = 50)
    private String trangThai = "Còn sách";
}