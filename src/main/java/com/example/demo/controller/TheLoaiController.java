package com.example.demo.controller;

import com.example.demo.entity.TheLoai;
import com.example.demo.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theloai")
public class TheLoaiController {

    @Autowired
    private TheLoaiService theLoaiService;

    @GetMapping
    public ResponseEntity<List<TheLoai>> getAllTheLoai() {
        return ResponseEntity.ok(theLoaiService.getAllTheLoai());
    }
}