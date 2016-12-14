package com.tickets.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * Created by yang on 2016/12/3.
 */
public class DBPool {
    private static ComboPooledDataSource ds;
    static{
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/db_ticket");
            ds.setUser("root");
            ds.setPassword("root");
            ds.setInitialPoolSize(5);
            ds.setMinPoolSize(1);
            ds.setMaxPoolSize(20);
            ds.setMaxStatements(50);
            ds.setMaxIdleTime(60);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static final Connection getConnection(){
        try{
            return ds.getConnection();
        }catch (Exception e){
            throw new RuntimeException("无法从连接源得到连接", e);
        }
    }
}
