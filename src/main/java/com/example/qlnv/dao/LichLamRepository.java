package com.example.qlnv.dao;

import com.example.qlnv.entities.LichLamEntity;
import com.example.qlnv.entities.LichLamPK;
import com.example.qlnv.entities.TaiKhoanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface LichLamRepository extends JpaRepository<LichLamEntity, LichLamPK> {
    @Modifying()
    @Query(value = "insert into lichlam (manv, ngay, ca, ghichu) values (:manv, :ngay, :ca, :ghichu)", nativeQuery = true)
    @Transactional
    void addL(@Param("manv")String manv, @Param("ngay") String ngay,
               @Param("ca") String ca, @Param("ghichu") String ghichu);
    
    @Query(value = "select * from lichlam u where u.manv = :manv" ,
            nativeQuery = true)
    @Transactional
    Collection<LichLamEntity> getTK(@Param("manv")String manv);
    
    @Query(value = "select * from lichlam where manv = :manv AND MONTH(NGAY) = :thang" ,
            nativeQuery = true)
    @Transactional
    List<LichLamEntity> getLbyM(@Param("manv")String manv, @Param("thang")int thang);
}
