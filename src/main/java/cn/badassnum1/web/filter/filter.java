package cn.badassnum1.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        if(uri.contains("/login.jsp") ||uri.contains("/adminLogin.jsp") ||
                uri.contains("/adminLoginServlet")|| uri.contains("/loginServlet") ||
                uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") ||
                uri.contains("/add.jsp")||uri.contains("/addUserServlet")||
                uri.contains("/checkCodeServlet")){
            chain.doFilter(request,response);
        }
        else{
            Object user = req.getSession().getAttribute("user");
            Object admin = req.getSession().getAttribute("admin");

            if(user != null||admin!=null){
                chain.doFilter(request,response);
            }
            else {
                req.setAttribute("login_msg","您尚未登录");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        }

    }
}
