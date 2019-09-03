package com.zcl.datasource.druid;

import com.zcl.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用工具类
 */
public class DruidTest2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="insert into t_account values(null,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"zcl");
            ps.setInt(2,10000);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn);
        }
    }
}
