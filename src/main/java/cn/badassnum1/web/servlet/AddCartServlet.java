package cn.badassnum1.web.servlet;

import cn.badassnum1.domain.Book;
import cn.badassnum1.domain.User;
import cn.badassnum1.service.BookService;
import cn.badassnum1.service.UserService;
import cn.badassnum1.service.impl.BookServiceImpl;
import cn.badassnum1.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");

        BookService bookService = new BookServiceImpl();
        Book book = bookService.findBookById(bid);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/books.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
