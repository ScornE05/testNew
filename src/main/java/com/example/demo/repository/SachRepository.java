package com.example.demo.repository;

import com.example.demo.entity.Sach;
import com.example.demo.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
    List<Sach> findByTenSachContainingOrTacGiaContaining(String tenSach, String tacGia);

    List<Sach> findByTheLoai(TheLoai theLoai);

    @Query("SELECT s.theLoai.tenTheLoai, COUNT(s) FROM Sach s GROUP BY s.theLoai.tenTheLoai")
    List<Object[]> thongKeSoLuongSachTheoTheLoai();
}