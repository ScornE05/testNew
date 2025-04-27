package com.example.demo.controller;

import com.example.demo.entity.Sach;
import com.example.demo.entity.TheLoai;
import com.example.demo.service.SachService;
import com.example.demo.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/sach")
public class SachController {

    @Autowired
    private SachService sachService;

    @Autowired
    private TheLoaiService theLoaiService;

    @GetMapping
    public ResponseEntity<List<Sach>> getAllSach() {
        return ResponseEntity.ok(sachService.getAllSach());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Sach>> searchSach(@RequestParam String keyword) {
        return ResponseEntity.ok(sachService.searchSach(keyword));
    }

    @GetMapping("/theloai/{maTheLoai}")
    public ResponseEntity<List<Sach>> getSachByTheLoai(@PathVariable Integer maTheLoai) {
        Optional<TheLoai> theLoaiOpt = theLoaiService.getTheLoaiById(maTheLoai);
        return theLoaiOpt.map(theLoai ->
                ResponseEntity.ok(sachService.getSachByTheLoai(theLoai))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sach> createSach(@RequestBody Sach sach) {
        return new ResponseEntity<>(sachService.saveSach(sach), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sach> updateSach(@PathVariable Integer id, @RequestBody Sach sach) {
        Sach updatedSach = sachService.updateSach(id, sach);
        return updatedSach != null ?
                ResponseEntity.ok(updatedSach) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/trangthai")
    public ResponseEntity<Sach> updateTrangThaiSach(
            @PathVariable Integer id,
            @RequestBody Map<String, String> body) {
        String trangThai = body.get("trangThai");
        Sach updatedSach = sachService.updateTrangThaiSach(id, trangThai);
        return updatedSach != null ?
                ResponseEntity.ok(updatedSach) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/thongke")
    public ResponseEntity<List<Map<String, Object>>> getThongKeSachTheoTheLoai() {
        return ResponseEntity.ok(sachService.getThongKeSachTheoTheLoai());
    }
}