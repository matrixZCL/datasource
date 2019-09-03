package com.zcl.jdbctemplate;

import com.zcl.entity.Account;
import com.zcl.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest2 {
    //Junit单元测试，让方法独立执行
    DataSource ds=JDBCUtils.getDataSource();
    JdbcTemplate template=new JdbcTemplate(ds);

    @Test
    public void test1(){
        String sql="update t_account set money=123123 where id =1";
        template.update(sql);
    }

    @Test
    public void test2(){
        String sql="insert into t_account values(?,?,?)";
        template.update(sql,null,"pony",100000);
    }

    //查询id为1的记录，并封装成集合
    @Test
    public void test3(){
        String sql="select * from t_account where id = ?";
        Map<String,Object> map=template.queryForMap(sql,1);
        System.out.println(map);
    }

    //查询所有记录，封装为List
    @Test
    public void test4(){
        String sql="select * from t_account";
        List<Map<String,Object>>list=template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    //查询所有记录，封装成Account对象的List集合
    @Test
    public void test5(){
        String sql="select * from t_account";
        List<Account> list=template.query(sql, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet rs, int i) throws SQLException {
                Account account=new Account();
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int money=rs.getInt("money");

                account.setId(id);
                account.setName(name);
                account.setMoney(money);
                return account;
            }
        });

        for (Account account : list) {
             System.out.println(account);
        }

    }

    @Test
    public void test6(){
        String sql="select * from t_account";
        List<Account> list=template.query(sql,new BeanPropertyRowMapper<>(Account.class));

        for (Account account : list) {
            System.out.println(account);
        }
    }

    //查询总记录数,该方法用于聚合函数的查询
    @Test
    public void test7(){
        String sql="select count(id) from t_account";
        Long l=template.queryForObject(sql,Long.class);
        System.out.println(l);
    }


}
