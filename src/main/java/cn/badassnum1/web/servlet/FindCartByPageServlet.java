package cn.badassnum1.web.servlet;




import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.Cart;
import cn.badassnum1.domain.PageBean;

import cn.badassnum1.service.CartService;
import cn.badassnum1.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/findCartByPageServlet")
public class FindCartByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String iid = request.getParameter("iid");
        System.out.println(iid+"this is iid");
        CartService service = new CartServiceImpl();
        List<Book> list=service.findCartBook(iid);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
