package com.example.qlnv.dao;

import com.example.qlnv.entities.TrangThaiNVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiRepository extends JpaRepository<TrangThaiNVEntity, String> {
}
