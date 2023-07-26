package com.example.qlnv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.qlnv.entities.HinhThucEntity;

@Repository
public interface HinhThucRepository extends JpaRepository<HinhThucEntity, String>{

}
