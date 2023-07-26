package com.example.qlnv.dao;

import com.example.qlnv.entities.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, String> {

    @Modifying()
    @Query(value = "update NhanVienEntity nv set nv.HO = :hoten, nv.GIOITINH = :gioitinh, nv.TEN = :ten, nv.DIACHI = :diachi, nv.CHUCVU = :chucvu, " +
            "nv.CHINHANH = :chinhanh, nv.SDT = :sdt, nv.TRANGTHAI = :trangthai," +
            "nv.HINHANH = :hinhanh, nv.NGAYSINH = :ngaysinh, nv.HINHTHUC = :hinhthuc  where nv.MANV = :manv")
    @Transactional
    void editNV(@Param("manv") String manv, @Param("hoten") String hoten,
          @Param("ten") String ten, @Param("diachi") String diachi, @Param("chucvu") String chucvu,
          @Param("chinhanh") String chinhanh, @Param("sdt") String sdt, 
          @Param("trangthai") String trangthai, @Param("hinhanh")String hinhanh,
          @Param("gioitinh")String gioitinh, @Param("ngaysinh")String ngaysinh,
          @Param("hinhthuc")String hinhthuc);



    @Modifying()
    @Query(value = "insert into nhanvien (manv, ho, ten, diachi, chucvu, chinhanh, hinhthuc, trangthai, gioitinh, ngaysinh) values (:manv, :hoten, :ten," +
            ":diachi, :chucvu, :chinhanh, :hinhthuc, :trangthai, :gioitinh, :ngaysinh)", nativeQuery = true)
    @Transactional
    void addNV(@Param("manv")String manv, @Param("hoten") String hoten,
               @Param("ten") String ten, @Param("diachi") String diachi, @Param("chucvu") String chucvu,
               @Param("chinhanh") String chinhanh, @Param("hinhthuc") String hinhthuc,
               @Param("trangthai") String trangthai, @Param("gioitinh")String gioitinh,
               @Param("ngaysinh")String ngaysinh);

}
