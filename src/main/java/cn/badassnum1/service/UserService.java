package cn.badassnum1.service;

import cn.badassnum1.domain.PageBean;
import cn.badassnum1.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    
    public List<User> findAll();

    User login(User user);

    void addUser(User user);

    void updateUser(User user);

    void delSelectedUser(String[] ids);

    void deleteUser(String id);

    User findUserById(String id);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
