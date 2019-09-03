package com.zcl.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test1 {
    public static void main(String[] args) throws SQLException {
        DataSource ds= new ComboPooledDataSource();
        //获取连接对象
        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
