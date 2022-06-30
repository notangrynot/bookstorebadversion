package cn.badassnum1.service.impl;

import cn.badassnum1.dao.BookDao;
import cn.badassnum1.dao.impl.BookDaoImpl;
import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.PageBean;
import cn.badassnum1.domain.Book;
import cn.badassnum1.service.BookService;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();
    public List<Book> findAll() {
        return dao.findAll();
    }

    @Override
    public Book login(Book book) {
        return null;
    }
//    public Book login(Book book){
//        return dao.findBookByBooknameAndPassword(book.getBookname(),book.getPassword());
//    }

    @Override
    public void addBook(Book book) {
        dao.add(book);
    }

    @Override
    public void updateBook(Book book) {
        dao.update(book);
    }

    @Override
    public void delSelectedBook(String[] ids) {
        if(ids != null && ids.length>0){
            for (String id: ids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public void deleteBook(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Book findBookById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public PageBean<Book> findBookByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage<=0){
            currentPage = 1;
        }
        if(currentPage*rows> dao.findTotalCount(condition)){
            currentPage = dao.findTotalCount(condition)/5+1;
        }

        PageBean<Book> pb = new PageBean<Book>();

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1)* rows;
        List<Book> list = dao.findByPage(start,rows,condition);
        pb.setList(list);
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
    }

