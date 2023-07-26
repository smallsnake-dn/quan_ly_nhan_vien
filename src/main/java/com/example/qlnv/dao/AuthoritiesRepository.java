package com.example.qlnv.dao;

import com.example.qlnv.entities.Authorities;
import com.example.qlnv.entities.AuthoritiesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesPK> {
    @Modifying
    @Query(value = "insert into authorities (username, authority) values (:username, " +
            ":authority)", nativeQuery = true)
    @Transactional
    void saveTK(@Param("username") String username, @Param("authority") String authority);


    @Modifying()
    @Query(value = "update authorities set authority = :authority where username = :username", nativeQuery = true)
    @Transactional
    void editAuthor(@Param("username") String username, @Param("authority") String authority);
}

