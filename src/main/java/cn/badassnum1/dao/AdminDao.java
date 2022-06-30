package cn.badassnum1.dao;

import cn.badassnum1.domain.Admin;
import cn.badassnum1.domain.User;

import java.util.List;

public interface AdminDao {
    public default List<Admin> findAll()
    {
        return null;
    }
    Admin findAdminByUsernameAndPassword(String adname, String password);

}
