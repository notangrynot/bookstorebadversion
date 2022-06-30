package cn.badassnum1.web.servlet;

import cn.badassnum1.domain.Book;
import cn.badassnum1.service.BookService;
import cn.badassnum1.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findBookServlet")
public class FindBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");

        //2.调用Service查询
        BookService service = new BookServiceImpl();
        Book book = service.findBookById(id);

        //3.将user存入request
        request.setAttribute("book",book);
        //4.转发到update.jsp
        request.getRequestDispatcher("/bookupdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
