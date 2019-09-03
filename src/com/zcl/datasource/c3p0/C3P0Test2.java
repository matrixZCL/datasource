package com.zcl.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池参数
 */
public class C3P0Test2 {
    public static void main(String[] args) throws SQLException {
        DataSource ds=new ComboPooledDataSource();
        for(int i=0;i<11;i++){
            Connection conn=ds.getConnection();
            System.out.println(i+":"+conn);

            //连接池10个对象，归还一个连接到连接池，不会报错
            if(i==5){
                conn.close();
            }

        }
    }
}
