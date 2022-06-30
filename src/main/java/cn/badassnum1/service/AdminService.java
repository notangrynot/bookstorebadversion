package cn.badassnum1.service;

import cn.badassnum1.domain.Admin;
import cn.badassnum1.domain.User;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();


    Admin login(Admin admin);
}
