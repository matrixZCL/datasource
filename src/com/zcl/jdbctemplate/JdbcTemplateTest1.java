package com.zcl.jdbctemplate;

import com.zcl.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest1 {
    public static void main(String[] args) {
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update t_account set money=500000 where id =?";
        int count=template.update(sql,3);
        System.out.println(count);


    }
}
