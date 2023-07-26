package com.example.qlnv.dao;

import com.example.qlnv.entities.LoaiTPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTPRepository extends JpaRepository<LoaiTPEntity, String> {
}
