package cn.badassnum1.service;

import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.PageBean;
import cn.badassnum1.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    public List<Book> findAll();

    Book login(Book book);

    void addBook(Book book);

    void updateBook(Book book);

    void delSelectedBook(String[] ids);

    void deleteBook(String id);

    Book findBookById(String id);

    PageBean<Book> findBookByPage(String currentPage, String rows, Map<String, String[]> condition);
}
