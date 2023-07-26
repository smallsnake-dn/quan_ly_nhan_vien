package com.example.qlnv.services;

import com.example.qlnv.entities.ChucVuEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChucVuService {
    public List<ChucVuEntity> getAll();
}
