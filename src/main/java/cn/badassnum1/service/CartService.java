package cn.badassnum1.service;

import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.Cart;
import cn.badassnum1.domain.PageBean;

import java.util.List;
import java.util.Map;

public interface CartService {

    void addCart(Cart cart);

    PageBean<Cart> findCartByPage(String currentPage, String rows, Map<String, String[]> condition);


    void deleteCart(String iid,String bid);

    List<Book> findCartBook(String iid);
}
