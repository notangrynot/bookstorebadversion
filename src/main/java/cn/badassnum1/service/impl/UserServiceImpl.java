package cn.badassnum1.service.impl;

import cn.badassnum1.dao.UserDa;
import cn.badassnum1.dao.impl.UserDaoImpl;
import cn.badassnum1.domain.PageBean;
import cn.badassnum1.domain.User;
import cn.badassnum1.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDa dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
    public User login(User user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids != null && ids.length>0){
        for (String id: ids){
            dao.delete(Integer.parseInt(id));
        }
        }
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage<=0){
            currentPage = 1;
        }
        if(currentPage*rows> dao.findTotalCount(condition)){
            currentPage = dao.findTotalCount(condition)/5+1;
        }

        PageBean<User> pb = new PageBean<User>();

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1)* rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;
     }
}
