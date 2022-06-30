package cn.badassnum1.dao.impl;

import cn.badassnum1.dao.BookDao;
import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.User;
import cn.badassnum1.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Book> findAll(){
        String sql = "select * from book";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public void add(Book book) {
        String sql = "insert into book values(null,?,?,?,?,?)";
        template.update(sql,book.getISBN(),book.getClasno(),book.getBookname(),
                book.getAuthor(),book.getPrice());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from book where id = ?";
        template.update(sql,id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {

        String sql = "select count(*) from book where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Book> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from book where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<Book>(Book.class),params.toArray());
    }

    @Override
    public Book findById(int id) {
        String sql = "select * from book where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    @Override
    public void update(Book book) {
        String sql = "update book set ISBN = ? , clasno = ? ,bookname = ?,author = ?,price = ? where id = ?";
        template.update(sql,book.getISBN(),book.getClasno(),book.getBookname(),
                book.getAuthor(),book.getPrice(),book.getId());
    }
}
