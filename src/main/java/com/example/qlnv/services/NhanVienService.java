package com.example.qlnv.services;

import com.example.qlnv.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NhanVienService {
    public String addNV(NhanVienEntity nhanVien);
    public String updateNV(NhanVienEntity nhanVien);
    public String deleteNV(String id);
    public List<NhanVienEntity> getListNhanVien();
    public List<ChiNhanhEntity> getListChiNhanh();
    public List<TrangThaiNVEntity> getListTrangThaiNvEntities();
    public List<ChucVuEntity> getListChucVu();
    public List<HinhThucEntity> getListHinhThuc();



}
