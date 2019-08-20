/**
 * @Title: FindUserServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/27 0:00 AM
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
 * @className: FindUserServlet
 * @description: 查询用户信息
 * @author: ZSZ
 * @date: 2019/7/28 0:00
 */
@WebServlet(name = "FindUserServlet",urlPatterns = "/finduser")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User user = null;
        String error = "";
        PrintWriter out = response.getWriter();

        String uid = request.getParameter("uid");
        try {
            user = DAOFactory.getUserDAOInstance().findUserById(new User(Integer.parseInt(uid)));
            if (user == null){
                error = error + "该ID不存在！；";
            }else {
                code = 1;
            }
        }catch (NumberFormatException e){
            code = -2;
            e.printStackTrace();
        } catch (Exception e){
            code = 0;
            error = error + "服务端错误！；";
            e.printStackTrace();
        }

        ServletUtil.responseOutWriter(out,code,error,user);
    }
}
