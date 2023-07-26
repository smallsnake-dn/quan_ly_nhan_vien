package com.example.qlnv.services;

import com.example.qlnv.dao.ThuongPhatRepository;
import com.example.qlnv.entities.ThuongPhatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIServiceImpl implements KPIService{
    private ThuongPhatRepository thuongPhatRepository;
    @Autowired
    public void setKPIRepository(ThuongPhatRepository thuongPhatRepository){
        this.thuongPhatRepository = thuongPhatRepository;
    }

    @Override
    public List<ThuongPhatEntity> getAll() {
        return thuongPhatRepository.findAll();
    }
}
