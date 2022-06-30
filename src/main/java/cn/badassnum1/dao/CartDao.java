package cn.badassnum1.dao;

import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.Cart;

import java.util.List;
import java.util.Map;

public interface CartDao {

    void addCart(Cart cart);

    int findTotalCount(Map<String, String[]> condition);

    List<Cart> findByPage(int start, int rows, Map<String, String[]> condition);



    void delete(int iid,int bid);

    List<Book> findCartBook(int iid);
}
