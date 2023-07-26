package com.example.qlnv.dao;

import com.example.qlnv.entities.ChucVuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVuEntity, String> {
}
