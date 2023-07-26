package com.example.qlnv.dao;

import com.example.qlnv.entities.ChamCongEntity;
import com.example.qlnv.entities.ChamCongPK;
import com.example.qlnv.entities.LichLamEntity;
import com.example.qlnv.entities.ThuongPhatEntity;
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
public interface ChamCongRepository extends JpaRepository<ChamCongEntity, ChamCongPK> {

    @Query(value = "select * from chamcong where MONTH(NGAY) = :thang AND MANV = :manv",
            nativeQuery = true)
    @Transactional
    List<ChamCongEntity> selectCC(@Param("manv") String manv, @Param("thang") int thang);
    
    @Query(value = "select * from chamcong where NGAY = :thang AND MANV = :manv",
            nativeQuery = true)
    @Transactional
    List<ChamCongEntity> selectCCbyNV(@Param("manv") String manv, @Param("thang") Date thang);
    
    @Query(value = "select * from chamcong u where u.manv = :manv" ,
            nativeQuery = true)
    @Transactional
    Collection<ChamCongEntity> getTK(@Param("manv")String manv);
}
