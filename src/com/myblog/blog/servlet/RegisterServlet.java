/**
 * @Title: RegisterServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/27 14:00 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: RegisterServlet
 * @description: 注册
 * @author: ZSZ
 * @date: 2019/7/27 14:00 PM
 */
@WebServlet(urlPatterns = "/register",name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        int code = 0;
        User user = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if(ServletUtil.isNotNull(new String[]{uid,username,password,sex,telephone,email,role})){
            try {
                int userId = Integer.parseInt(uid);
                if ( DAOFactory.getUserDAOInstance().findUserById(new User(userId))== null) {
                    user = new User(userId, username, password, sex, telephone, email, Integer.parseInt(role), null, 1);
                    try {
                        DAOFactory.getUserDAOInstance().addUser(user);
                        request.getSession().setAttribute(uid, user);
                        code = 1;
                    } catch (Exception e) {
                        code = 0;
                        request.getSession().removeAttribute(uid);
                        error = error + "数据存入数据库错误！；";
                        e.printStackTrace();
                    }
                } else {
                    code = 0;
                    error = error + "该ID已被注册！；";
                }
            } catch (NumberFormatException e) {
                code = -2;
                e.printStackTrace();
            } catch (Exception e) {
                code = 0;
                error = error + "服务端错误！；";
                e.printStackTrace();
            }
        }
        else{
            code = -2;
        }

        ServletUtil.responseOutWriter(out,code,error,user);

    }
}
