package com.example.qlnv.services;

import com.example.qlnv.entities.ChiNhanhEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChiNhanhService {
    public List<ChiNhanhEntity> getAll();
    public String addCN(ChiNhanhEntity chiNhanh);
    public ChiNhanhEntity getCNById(String Id);
}
