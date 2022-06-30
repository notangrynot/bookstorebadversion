package cn.badassnum1.dao;

import cn.badassnum1.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDa {
    public default List<User> findAll()
    {
        return null;
    }

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int parseInt);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    User findById(int parseInt);

    void update(User user);
}
