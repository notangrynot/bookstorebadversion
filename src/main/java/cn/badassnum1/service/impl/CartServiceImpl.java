package cn.badassnum1.service.impl;

import cn.badassnum1.dao.CartDao;
import cn.badassnum1.dao.impl.CartDaoImpl;
import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.Cart;
import cn.badassnum1.domain.PageBean;
import cn.badassnum1.service.CartService;

import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {
    private CartDao dao = new CartDaoImpl();


    @Override
    public void addCart(Cart cart) {
        dao.addCart(cart);
    }

    @Override
    public PageBean<Cart> findCartByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage<=0){
            currentPage = 1;
        }
        if(currentPage*rows> dao.findTotalCount(condition)){
            currentPage = dao.findTotalCount(condition)/5+1;
        }

        PageBean<Cart> pb = new PageBean<Cart>();

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1)* rows;
        List<Cart> list = dao.findByPage(start,rows,condition);
        pb.setList(list);
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(totalPage);
        return pb;

    }




    @Override
    public void deleteCart(String iid,String bid) {
        dao.delete(Integer.parseInt(iid),Integer.parseInt(bid));
    }

    @Override
    public List<Book> findCartBook(String iid) {
        return dao.findCartBook(Integer.parseInt(iid));
    }
}
