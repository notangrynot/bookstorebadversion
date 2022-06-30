package cn.badassnum1.web.servlet;


import cn.badassnum1.service.BookService;
import cn.badassnum1.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delBookServlet")
public class DelBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        BookService service = new BookServiceImpl();
        service.deleteBook(id);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findBookByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
