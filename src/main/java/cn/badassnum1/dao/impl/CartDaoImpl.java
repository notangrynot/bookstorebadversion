package cn.badassnum1.dao.impl;

import cn.badassnum1.dao.CartDao;
import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.Cart;
import cn.badassnum1.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CartDaoImpl implements CartDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public void addCart(Cart cart) {
        String sql = "insert into cart values(?,?,?)";
        template.update(sql,cart.getIid(),cart.getBid(),cart.getCount());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from cart where 1 = 1 ";
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
    public List<Cart> findByPage(int start, int rows, Map<String, String[]> condition) {
        {
            String sql = "select * from cart where 1 = 1";
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
            return template.query(sb.toString(),new BeanPropertyRowMapper<Cart>(Cart.class),params.toArray());
        }
    }

    @Override
    public void delete(int iid,int bid) {
        String sql = "delete from cart where iid = ? and bid = ?";
        template.update(sql,iid,bid);
    }

    @Override
    public List<Book> findCartBook(int iid) {
        String sql = "select book.* from cart, book where cart.bid = book.id and cart.iid = ?";
        List<Book> list=template.query(sql,new BeanPropertyRowMapper<Book>(Book.class),iid);
        return list;
    }


}
