/**
 * @Title: ReviseServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 0:30 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * @className: ReviseServlet
 * @description: 修改个人信息
 * @author: ZSZ
 * @date: 2019/7/28 0:30
 */
@WebServlet(name = "ReviseServlet",urlPatterns = "/u/revise")
public class ReviseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User user = null;
        User newUser = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String sex = request.getParameter("sex");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
            String uid = request.getParameter("uid");

            user = (User) request.getSession().getAttribute(uid);

            int role = user.getRole();
            int status = user.getStatus();
            String image = user.getImage();



            if(ServletUtil.isNotNull(new String[]{uid,username,password,sex,telephone,email})) {
                if(uid.equals(Integer.toString(user.getId()))){
                    try {
                        if (DAOFactory.getUserDAOInstance().findUserById(user) != null) {
                            user = new User(user.getId(), username, password, sex, telephone, email, role, image, status);
                            newUser = DAOFactory.getUserDAOInstance().updateUser(user);
                            if (newUser != null){
                                request.getSession().setAttribute("user", newUser);
                                List<Blog> blogList = DAOFactory.getBlogDAOInstance().findBlogListByUid(user);
                                code = 1;
                                if(blogList != null && blogList.size()!= 0){
                                    Iterator<Blog> iterator = blogList.iterator();
                                    while (iterator.hasNext()){
                                        Blog blog = iterator.next();
                                        blog.setAuthor(newUser.getUsername());
                                        DAOFactory.getBlogDAOInstance().updateBlogAuthor(blog);
                                    }
                                }
                            }else {
                                error = error + "数据存入数据库错误！；";
                            }
                        } else {
                            error = error + "该用户不存在！；";
                        }
                    } catch (NumberFormatException e) {
                        code = -2;
                        e.printStackTrace();
                    } catch (Exception e) {
                        code = 0;
                        error = error + "服务端错误！；";
                        e.printStackTrace();
                    }
                }else {
                    code = -2;
                }
            } else{
                code = -2;
            }
        }

        ServletUtil.responseOutWriter(out,code,error,newUser);
    }
}
