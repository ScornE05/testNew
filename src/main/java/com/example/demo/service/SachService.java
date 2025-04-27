package com.example.demo.service;

import com.example.demo.entity.Sach;
import com.example.demo.entity.TheLoai;
import com.example.demo.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SachService {

    @Autowired
    private SachRepository sachRepository;

    public List<Sach> getAllSach() {
        return sachRepository.findAll();
    }

    public Optional<Sach> getSachById(Integer id) {
        return sachRepository.findById(id);
    }

    public List<Sach> searchSach(String keyword) {
        return sachRepository.findByTenSachContainingOrTacGiaContaining(keyword, keyword);
    }

    public List<Sach> getSachByTheLoai(TheLoai theLoai) {
        return sachRepository.findByTheLoai(theLoai);
    }

    public Sach saveSach(Sach sach) {
        return sachRepository.save(sach);
    }

    public Sach updateSach(Integer id, Sach sachUpdate) {
        if(sachRepository.existsById(id)) {
            sachUpdate.setMaSach(id);
            return sachRepository.save(sachUpdate);
        }
        return null;
    }

    public Sach updateTrangThaiSach(Integer id, String trangThai) {
        Optional<Sach> sachOpt = sachRepository.findById(id);
        if(sachOpt.isPresent()) {
            Sach sach = sachOpt.get();
            sach.setTrangThai(trangThai);
            return sachRepository.save(sach);
        }
        return null;
    }

    public List<Map<String, Object>> getThongKeSachTheoTheLoai() {
        List<Object[]> result = sachRepository.thongKeSoLuongSachTheoTheLoai();
        return result.stream().map(row -> {
            Map<String, Object> map = Map.of(
                    "tenTheLoai", row[0],
                    "soLuong", row[1]
            );
            return map;
        }).collect(Collectors.toList());
    }
}