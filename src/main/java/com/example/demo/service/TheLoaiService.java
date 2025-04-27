package com.example.demo.service;

import com.example.demo.entity.TheLoai;
import com.example.demo.repository.TheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheLoaiService {

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    public List<TheLoai> getAllTheLoai() {
        return theLoaiRepository.findAll();
    }

    public Optional<TheLoai> getTheLoaiById(Integer id) {
        return theLoaiRepository.findById(id);
    }
}