package cn.badassnum1.dao.impl;

import cn.badassnum1.dao.AdminDao;
import cn.badassnum1.domain.Admin;
import cn.badassnum1.domain.User;
import cn.badassnum1.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Admin> findAll() {
        String sql = "select * from admin";
        List<Admin> admins = template.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
        return admins;
    }

    @Override
    public Admin findAdminByUsernameAndPassword(String adname, String password) {
        try {
            String sql = "select * from admin where adname = ? and password = ?";
            Admin admin=template.queryForObject(sql,
                    new BeanPropertyRowMapper<Admin>(Admin.class),
                    adname,password);
            return admin;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


}
