/**
 * @Title: DeleteReviewServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 13:40 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
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

/**
 * @className: DeleteReviewServlet
 * @description: 删除评论
 * @author: ZSZ
 * @date: 2019/7/28 13:40
 */
@WebServlet(name = "DeleteReviewServlet",urlPatterns = "/u/deletereview")
public class DeleteReviewServlet extends HttpServlet {
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

            String rid = request.getParameter("rid");
            String uid = request.getParameter("uid");
            user = (User) request.getSession().getAttribute(uid);

            if (ServletUtil.isNotNull(new String[]{rid,uid})){
                if (uid.equals(Integer.toString(user.getId()))){
                    try{
                        Review review = new Review(Integer.parseInt(rid));
                        if (DAOFactory.getReviewDAOInstance().findReviewByRid(review)!= null){
                            DAOFactory.getReviewDAOInstance().removeReviewById(review);
                            code = 1;
                        }else {
                            error = error + "该评论不存在";
                        }
                    }catch (NumberFormatException e){
                        code = -2;
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

        ServletUtil.responseOutWriter(out,code,error);
    }
}
