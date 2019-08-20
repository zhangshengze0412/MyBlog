/**
 * @Title: ReviewServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 12:42 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @className: ReviewServlet
 * @description: 实现添加评论功能
 * @author: ZSZ
 * @date: 2019/7/28 12:42
 */
@WebServlet(name = "ReviewServlet",urlPatterns = "/u/article/review")
public class ReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User user = null;
        Review review = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {

            String uid = request.getParameter("uid");
            String bid = request.getParameter("bid");
            String context = request.getParameter("context");
            user = (User) request.getSession().getAttribute(uid);

            if(ServletUtil.isNotNull(new String[]{uid,bid,context})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        if(DAOFactory.getBlogDAOInstance().findBlogById(new Blog(Integer.parseInt(bid)))!=null){
                            review = new Review(user.getId(),Integer.parseInt(bid),context,new Date());
                            DAOFactory.getReviewDAOInstance().addReview(review);

                            code = 1;
                        }else {
                            error = error + "该博客不存在！；";
                        }

                    }catch (NumberFormatException e){
                        code = -2;
                        e.printStackTrace();
                    }catch (Exception e){
                        code = 0;
                        error = error + "服务端错误！；";
                    }
                }else {
                    code = -2;
                }

            }else{
                code = -2;
            }

        }

        ServletUtil.responseOutWriter(out,code,error,review);
    }
}
