package com.example.qlnv.dao;

import com.example.qlnv.entities.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import javax.transaction.Transactional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, String> {
    @Modifying
    @Query(value = "insert into users (username, MANV, password, enabled) values (:username, " +
            ":MANV, :password, :enabled)", nativeQuery = true)
    @Transactional
    void saveTK(@Param("username") String username, @Param("MANV") String MANV, @Param("password") String password,
                @Param("enabled")String enabled);



    @Modifying
    @Query(value = "update users set password = :password, enabled = :enabled where username = :username", nativeQuery = true)
    @Transactional
    void editTK(@Param("username") String username, @Param("password") String password, @Param("enabled") String enabled);
    @Modifying
    @Query(value = "update users set enabled = :enabled where username = :username", nativeQuery = true)
    @Transactional
    void editTKNoP(@Param("username") String username, @Param("enabled") String enabled);
    
    
    @Query(value = "select * from users u where u.manv = :manv" ,
            nativeQuery = true)
    @Transactional
    Collection<TaiKhoanEntity> getTK(@Param("manv")String manv);
}
