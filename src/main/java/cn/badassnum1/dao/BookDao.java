package cn.badassnum1.dao;

import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.User;

import java.util.List;
import java.util.Map;

public interface BookDao {
    public default List<Book> findAll()
    {
        return null;
    }

    void add(Book book);

    void delete(int parseInt);

    int findTotalCount(Map<String, String[]> condition);

    List<Book> findByPage(int start, int rows, Map<String, String[]> condition);

    Book findById(int parseInt);

    void update(Book book);
}
