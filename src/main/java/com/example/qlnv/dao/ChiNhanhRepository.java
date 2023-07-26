package com.example.qlnv.dao;

import com.example.qlnv.entities.ChiNhanhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiNhanhRepository extends JpaRepository<ChiNhanhEntity, String> {
}
