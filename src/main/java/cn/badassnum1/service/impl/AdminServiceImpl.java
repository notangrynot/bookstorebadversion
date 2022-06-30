package cn.badassnum1.service.impl;

import cn.badassnum1.dao.AdminDao;
import cn.badassnum1.dao.UserDa;
import cn.badassnum1.dao.impl.AdminDaoImpl;
import cn.badassnum1.dao.impl.UserDaoImpl;
import cn.badassnum1.domain.Admin;
import cn.badassnum1.domain.User;
import cn.badassnum1.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public List<Admin> findAll() {
        return null;
    }

    public Admin login(Admin admin){
        return dao.findAdminByUsernameAndPassword(admin.getAdname(),admin.getPassword());
    }
}
