package com.example.qlnv.services;

import com.example.qlnv.entities.CaEntity;
import com.example.qlnv.entities.LichLamEntity;
import com.example.qlnv.entities.NhanVienEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LichLamService {
    public List<LichLamEntity> getAll();
    public List<NhanVienEntity> getNV();
    public List<CaEntity> getCa();
    public void addLich(String manv, String ngay, String ca, String ghichu);
}
