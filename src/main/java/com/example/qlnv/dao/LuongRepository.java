package com.example.qlnv.dao;

import com.example.qlnv.entities.ChamCongEntity;
import com.example.qlnv.entities.LuongEntity;
import com.example.qlnv.entities.LuongPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface LuongRepository extends JpaRepository<LuongEntity, LuongPK> {
    //    @Modifying
//    @Query(value = "select  from LUONGEntity as l where l.MANV = :manv AND MONTH(l.NGAY) = :thang group by MANV",
//            nativeQuery = true)
//    @Transactional
//    List<LuongEntity> selectC(@Param("manv") String manv, @Param("thang") int thang);
    @Query(value = "select l.MANV, l.LUONG, l.NGAY " +
            "from luong l " +
            "inner join (" +
            "    select l2.MANV, max(l2.NGAY) as MaxDate" +
            "    from luong l2" +
            "    group by l2.MANV" +
            ") tm on l.MANV = tm.MANV and l.NGAY = tm.MaxDate",
            nativeQuery = true)
    @Transactional
    List<LuongEntity> selectC();
    
    @Query(value = "select l.*  " +
            "from luong l " +
            "inner join (" +
            "    select l2.MANV, max(l2.NGAY) as MaxDate" +
            "    from luong l2 where l2.MANV = :manv AND MONTH(l2.NGAY) <= :thang " +
            "    group by l2.MANV" +
            ") tm on l.MANV = tm.MANV and l.NGAY = tm.MaxDate",
            nativeQuery = true)
    @Transactional
    LuongEntity selectML(@Param("manv")String manv, @Param("thang")int thang);

    @Modifying()
    @Query(value = "insert into luong (manv, ngay, mavbqd, luong, ghichu) " +
            "values (:manv, :ngay, :mavb, :luong, :ghichu)", nativeQuery = true)
    @Transactional
    void addL(@Param("manv")String manv, @Param("ngay") String ngay,
              @Param("mavb")String mavb, @Param("luong")String luong, @Param("ghichu") String ghichu);
    
    @Query(value = "select * from luong u where u.manv = :manv" ,
            nativeQuery = true)
    @Transactional
    Collection<LuongEntity> getTK(@Param("manv")String manv);
}
