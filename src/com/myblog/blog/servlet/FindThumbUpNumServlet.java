/**
 * @Title: FindThumbUpNumServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 20:37 PM
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

/**
 * @className: FindThumbUpNumServlet
 * @description: 根据文章查询点赞人数
 * @author: ZSZ
 * @date: 2019/7/28 20:37
 */
@WebServlet(name = "FindThumbUpNumServlet", urlPatterns = "/findthumbupnum")
public class FindThumbUpNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int num = 0;
        String error = "";
        PrintWriter out = response.getWriter();

        String bid = request.getParameter("bid");

        if(bid != null && !"".equals(bid)){
            try {
                int blogId = Integer.parseInt(bid);
                if(DAOFactory.getBlogDAOInstance().findBlogById(new Blog(blogId))!= null){
                    num = DAOFactory.getThumbUpDAOInstance().findThumbUpNumByBid(new Blog(blogId));
                    code = 1;
                }else {
                    error = error +"该博客不存在！；";
                }
            } catch (NumberFormatException e){
                code = -2;
            } catch (Exception e){
                code = 0;
                error = error + "服务端错误！；";
            }
        }else {
            code = -2;
        }

        ServletUtil.responseOutWriter(out,code,"total",num,error);
    }
}
