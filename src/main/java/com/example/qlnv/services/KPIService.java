package com.example.qlnv.services;

import com.example.qlnv.entities.ThuongPhatEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KPIService {
    public List<ThuongPhatEntity> getAll();
}
