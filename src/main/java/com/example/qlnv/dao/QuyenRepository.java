package com.example.qlnv.dao;

import com.example.qlnv.entities.QuyenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface QuyenRepository extends JpaRepository<QuyenEntity, String> {
}
