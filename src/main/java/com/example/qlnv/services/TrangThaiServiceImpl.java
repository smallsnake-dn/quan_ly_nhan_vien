package com.example.qlnv.services;

import com.example.qlnv.dao.TrangThaiRepository;
import com.example.qlnv.entities.TrangThaiNVEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrangThaiServiceImpl implements TrangThaiService{

    private TrangThaiRepository trangThaiRepository;
    @Autowired
    private void setTrangThaiRepository(TrangThaiRepository trangThaiRepository){
        this.trangThaiRepository = trangThaiRepository;
    }

    @Override
    public List<TrangThaiNVEntity> getAll() {
        return trangThaiRepository.findAll();
    }
}
