package com.example.qlnv.dao;

import com.example.qlnv.entities.LuongEntity;
import com.example.qlnv.entities.ThuongPhatEntity;
import com.example.qlnv.entities.ThuongPhatPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ThuongPhatRepository extends JpaRepository<ThuongPhatEntity, ThuongPhatPK> {

    @Query(value = "select * from thuongphat where MONTH(NGAY) = :thang AND MANV = :manv AND LOAI = 'L1'",
            nativeQuery = true)
    @Transactional
    List<ThuongPhatEntity> selectT(@Param("manv") String manv, @Param("thang") int thang);


    @Query(value = "select * from thuongphat where MONTH(NGAY) = :thang AND MANV = :manv AND LOAI = 'L2'",
            nativeQuery = true)
    @Transactional
    List<ThuongPhatEntity> selectP(@Param("manv") String manv, @Param("thang") int thang);

    @Modifying()
    @Query(value = "insert into thuongphat (manv, ngay, loai, mavb, sotien, ghichu) " +
            "values (:manv, :ngay, :loai, :mavb, :sotien, :ghichu)", nativeQuery = true)
    @Transactional
    void addTP(@Param("manv")String manv, @Param("ngay") String ngay, @Param("loai") String loai,
              @Param("mavb")String mavb, @Param("sotien")String sotien, @Param("ghichu") String ghichu);
}
