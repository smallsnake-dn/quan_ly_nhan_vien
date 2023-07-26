package com.example.qlnv.services;

import com.example.qlnv.dao.CaRepository;
import com.example.qlnv.dao.LichLamRepository;
import com.example.qlnv.dao.NhanVienRepository;
import com.example.qlnv.entities.CaEntity;
import com.example.qlnv.entities.LichLamEntity;
import com.example.qlnv.entities.NhanVienEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class LichLamServiceImpl implements LichLamService {
    private LichLamRepository lichLamRepository;

    @Autowired
    private void setLichLamRepository(LichLamRepository lichLamRepository) {
        this.lichLamRepository = lichLamRepository;
    }

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private CaRepository caRepository;

    @Override
    public List<LichLamEntity> getAll() {
        return lichLamRepository.findAll();
    }

    @Override
    public List<NhanVienEntity> getNV() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<CaEntity> getCa() {
        return caRepository.findAll();
    }

    @Override
    public void addLich(String manv, String ngay, String ca, String ghichu) {

        lichLamRepository.addL(manv, ngay, ca, ghichu);
    }
}
