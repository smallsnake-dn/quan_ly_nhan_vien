package com.example.qlnv.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuyenIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String prefix = "Q";
        Connection connection = sharedSessionContractImplementor.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(MAQ) as Id from quyen");

            if(rs.next())
            {
                int id=rs.getInt(1);
                String generatedId = prefix + Integer.toString(id);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
