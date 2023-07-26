package com.example.qlnv.services;

import com.example.qlnv.entities.NhanVienEntity;
import com.example.qlnv.entities.QuyenEntity;
import com.example.qlnv.entities.TaiKhoanEntity;
import com.example.qlnv.entities.Authorities;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface TaiKhoanService {
    public List<TaiKhoanEntity> getAll();
//    public TaiKhoanEntity register();

    public String register(TaiKhoanEntity taiKhoan);
    public List<HashMap<String, String>> getData();
    public List<NhanVienEntity> getListNV();
    public List<QuyenEntity> getRole();
    public void addRole(Authorities authorities);
    public void updateTK(String username, String password, String enable);
    public void updateAuthor(String username, String authority);
}
