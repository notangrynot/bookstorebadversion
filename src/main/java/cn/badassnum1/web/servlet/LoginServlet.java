package cn.badassnum1.web.servlet;

import cn.badassnum1.dao.Userdao;
import cn.badassnum1.domain.User;
import cn.badassnum1.service.UserService;
import cn.badassnum1.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        String verifycode = req.getParameter("verifycode");
        Map<String,String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            req.setAttribute("login_msg","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        if(loginUser != null){
            //将用户存入session
            session.setAttribute("user",loginUser);
            resp.sendRedirect(req.getContextPath()+"/userpage.jsp");
            //跳转页面
        }else{
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
