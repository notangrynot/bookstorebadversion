package cn.badassnum1.dao;

import cn.badassnum1.domain.User;
import cn.badassnum1.util.JDBCUtils;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Userdao {
    private JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());
    //登录
    public User login(User loginUser){
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user=template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            System.out.println(user);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }







}
