package com.example.qlnv.generator;

import com.example.qlnv.dao.NhanVienRepository;
import com.example.qlnv.entities.NhanVienEntity;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NhanVienIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String prefix = "NV";
        Connection connection = sharedSessionContractImplementor.connection();

//        try {
//            Statement statement=connection.createStatement();
//
//            ResultSet rs=statement.executeQuery("select count(MANV) as Id from nhanvien");
//
//            if(rs.next())
//            {
//                String generatedId;
//                int id;
//                while (true){
//                    id=rs.getInt(1);
//                    generatedId = prefix + Integer.toString(id);
//                    String query = "select MANV as Id from nhanvien where MANV = ''" + generatedId;
//
//                    ResultSet rs1 = null;
//                    try{
//                        rs1 = statement.executeQuery(query);
//                    }catch (Exception e){
//
//                    }
//                    System.out.println(query);
//                    System.out.println(rs1);
//                    if(rs1 == null){
//                        return generatedId;
//                    }else{
//                        id++;
//                    }
//                }
//
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select MAX(MANV) as Id from nhanvien");

            if(rs.next())
            {
                String[] rsstr = rs.getString(1).split("");
                System.out.println(rsstr[2]);
                String id= "";
                for(int i = 2; i<rsstr.length; i++){
                    id+=rsstr[i];
                }
                String generatedId = prefix + Integer.toString(Integer.valueOf(id) + 1);
                return generatedId;
            }else{
                return prefix + "1";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
