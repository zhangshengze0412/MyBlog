/**
 * @Title: LogoutServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/27 21:31 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.JSONUtil;
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
 * @className: LogoutServlet
 * @description: 注销
 * @author: ZSZ
 * @date: 2019/7/27 21:31
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/u/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User user = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {
            String uid = request.getParameter("uid");
            int Id = ((User)request.getSession().getAttribute(uid)).getId();
            if(uid.equals(Integer.toString(Id))){
                try {
                    user = DAOFactory.getUserDAOInstance().findUserById(new User(Integer.parseInt(uid)));
                    if (user == null){
                        error = error + "该ID不存在！；";
                    }else {
                        user.setStatus(0);
                        user = DAOFactory.getUserDAOInstance().updateUser(user);
                        if (user.getStatus()==0){
                            request.getSession().removeAttribute(uid);
                            code = 1;
                        }else {
                            error = error + "更新用户信息错误！；";
                        }
                    }
                }catch (NumberFormatException e){
                    code = -2;
                    e.printStackTrace();
                } catch (Exception e){
                    code = 0;
                    error = error + "服务端错误！；";
                    e.printStackTrace();
                }
            }else {
                code =-2;
            }
        }

        ServletUtil.responseOutWriter(out,code,error,user);
    }
}
