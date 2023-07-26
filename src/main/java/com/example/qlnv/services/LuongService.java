package com.example.qlnv.services;

import com.example.qlnv.entities.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface LuongService {
    public List<NhanVienEntity> getListNhanVien();
    public List<ChiNhanhEntity> getListChiNhanh();
    public List<ChamCongEntity> getListChamCong();
    public List<ThuongPhatEntity> getListThuongPhat();
    public List<LuongEntity> getListLuong();
    public HashMap<String, String> getLuong();
    public List<LuongThangEntity> getLuongNew();
    List<LoaiTPEntity> getListLoai();
    public void saveL(String manv, String ngay, String mavb, String luong, String ghichu);
    public void saveTP(String manv, String ngay,String loai, String mavb, String sotien, String ghichu);
}
