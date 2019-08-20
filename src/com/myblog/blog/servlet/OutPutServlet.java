/**
 * @Title: OutPutServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/29 8:56 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: OutPutServlet
 * @description: 向前端输出权限不足的JSON
 * @author: ZSZ
 * @date: 2019/7/29 8:56
 */
@WebServlet(name = "OutPutServlet" ,urlPatterns = {"/OutPutServlet","/u/OutPutServlet","/u/article/OutPutServlet","/admin/OutPutServlet"})
public class OutPutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        code = (int) request.getAttribute("code") ;
        if(code == -1){
            String msg = "insufficient permissions";
            response.getWriter().write(JSONUtil.setParameterForJson(code,msg).toString());
        }else if(code == -2){
            String msg = "param error";
            response.getWriter().write(JSONUtil.setParameterForJson(code,msg).toString());
        }

    }
}
