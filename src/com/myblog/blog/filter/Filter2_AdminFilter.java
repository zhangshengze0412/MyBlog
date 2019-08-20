/**
 * @Title: Filter2_AdminFilter.java
 * @Package com.myblog.blog.filter
 * @Description: filter
 * @author: ZSZ
 * @date: 2019/7/27 2I:22 PM
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
 * @className: Filter2_AdminFilter
 * @description: 检查是否为管理员
 * @author: ZSZ
 * @date: 2019/7/27 21:22
 */
@WebFilter(filterName = "Filter2_AdminFilter",urlPatterns = "/admin/*")
public class Filter2_AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        int code = 0;

        String uid = request.getParameter("uid");
        if (uid == null || "".equals(uid)){
            code = -2;
            request.setAttribute("code",code);
            request.getRequestDispatcher("OutPutServlet").forward(req,resp);
        }else {
            User user = (User) request.getSession().getAttribute(uid);
            if (user==null || user.getStatus()==0 ||user.getRole()>1 ){
                request.setAttribute("permissions",-1);
                code = -1;
                String msg = "insufficient permissions";
                response.getWriter().write(JSONUtil.setParameterForJson(code,msg).toString());
            }
        }

        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
