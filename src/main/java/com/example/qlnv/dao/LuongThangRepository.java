package com.example.qlnv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.qlnv.entities.LuongThangEntity;
import com.example.qlnv.entities.LuongThangPK;

@Repository
public interface LuongThangRepository extends JpaRepository<LuongThangEntity, LuongThangPK>{
	 @Query(value = "select * from luongthang where THANG = :thang AND MANV = :manv",
	            nativeQuery = true)
    @Transactional
	    List<LuongThangEntity> listLTbyM(@Param("thang")int thang, @Param("manv")String manv);
	 
	 @Modifying()
	    @Query(value = "insert into luongthang (manv, ngay, chinhanh, thang, tong, thuong, phat) "
	    		+ "values (:manv, :ngay, :chinhanh, :thang, :tong, :thuong, :phat)", nativeQuery = true)
	    @Transactional
	    void addLT(@Param("manv")String manv, @Param("ngay") String ngay, @Param("chinhanh")String chinhanh,
	    		@Param("thang")int thang, @Param("tong") float tong, @Param("thuong") float thuong, 
	               @Param("phat")float phat);
}
