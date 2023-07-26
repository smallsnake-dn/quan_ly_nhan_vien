package com.example.qlnv.services;

import com.example.qlnv.entities.TrangThaiNVEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrangThaiService {
    public List<TrangThaiNVEntity> getAll();
}
