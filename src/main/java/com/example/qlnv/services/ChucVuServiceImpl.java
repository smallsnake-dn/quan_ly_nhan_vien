package com.example.qlnv.services;

import com.example.qlnv.dao.ChucVuRepository;
import com.example.qlnv.entities.ChucVuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService{
    private ChucVuRepository chucVuRepository;

    @Autowired
    private void setChucVuRepository(ChucVuRepository chucVuRepository){
        this.chucVuRepository = chucVuRepository;
    }

    @Override
    public List<ChucVuEntity> getAll() {
        return chucVuRepository.findAll();
    }
}
