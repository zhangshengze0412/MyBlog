/**
 * @Title: Filter1_LoginFilter.java
 * @Package com.myblog.blog.filter
 * @Description: filter
 * @author: ZSZ
 * @date: 2019/7/27 20:33 PM
 * @version 1.0
 *
 */
package com.myblog.blog.filter;

import com.myblog.blog.util.JSONUtil;
import com.myblog.blog.vo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: Filter1_LoginFilter
 * @description: 检查是否登陆
 * @author: ZSZ
 * @date: 2019/7/27 20:33
 */
@WebFilter(filterName = "Filter1_LoginFilter",urlPatterns = "/u/*")
public class Filter1_LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        int code = 0;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        String uid = request.getParameter("uid");
        if (uid == null || "".equals(uid)){
            code = -2;
            request.setAttribute("code",code);
            request.getRequestDispatcher("OutPutServlet").forward(request,response);
        }else {
            try{
                int userID = Integer.parseInt(uid);
                User user = (User) request.getSession().getAttribute(uid);
                if (user==null || user.getStatus()==0 ||user.getRole()>2 ){
                    request.setAttribute("permissions",-1);
                    code = -1;
                    request.setAttribute("code",code);
                    request.getRequestDispatcher("OutPutServlet").forward(request,response);
                }
            }catch (NumberFormatException e){
                code = -2;
                request.setAttribute("code",code);
                request.getRequestDispatcher("OutPutServlet").forward(request,response);
            }
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
