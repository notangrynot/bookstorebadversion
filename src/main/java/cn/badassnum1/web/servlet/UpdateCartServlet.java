package cn.badassnum1.web.servlet;

import cn.badassnum1.domain.Cart;
import cn.badassnum1.service.CartService;
import cn.badassnum1.service.impl.CartServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateCartServlet")
public class UpdateCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String ,String[]> map = request.getParameterMap();
        String iid = request.getParameter("iid");
        Cart cart = new Cart();
        try {
            BeanUtils.populate(cart,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        CartService service = new CartServiceImpl();
        service.addCart(cart);
        response.sendRedirect(request.getContextPath()+"/findCartByPageServlet?iid="+iid);//跳转到cart页面
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
