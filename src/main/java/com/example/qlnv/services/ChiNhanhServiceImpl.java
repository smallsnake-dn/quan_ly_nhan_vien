package com.example.qlnv.services;

import com.example.qlnv.dao.ChiNhanhRepository;
import com.example.qlnv.entities.ChiNhanhEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiNhanhServiceImpl implements ChiNhanhService{
    private ChiNhanhRepository chiNhanhRepository;
    @Autowired
    private void setChiNhanhRepository(ChiNhanhRepository chiNhanhRepository){
        this.chiNhanhRepository = chiNhanhRepository;
    }
    @Override
    public List<ChiNhanhEntity> getAll() {
        return chiNhanhRepository.findAll();
    }

    @Override
    public String addCN(ChiNhanhEntity chiNhanh) {
        System.out.println("======Service");
        System.out.println(chiNhanh);
        Object obj = chiNhanhRepository.save(chiNhanh);
        return "OKKKK";
    }

    @Override
    public ChiNhanhEntity getCNById(String Id) {
        return chiNhanhRepository.getById(Id);
    }


}
