/**
 * @Title: DeleteServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 9:08 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.BlogClassification;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @className: DeleteServlet
 * @description: 实现博客删除功能
 * @author: ZSZ
 * @date: 2019/7/28 9:08
 */
@WebServlet(name = "DeleteServlet",urlPatterns = "/u/article/delete")
public class DeleteServlet extends HttpServlet {
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
            String bid = request.getParameter("bid");
            String uid = request.getParameter("uid");
            user = (User) request.getSession().getAttribute(uid);

            if (ServletUtil.isNotNull(new String[]{uid,bid})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        Blog blog = new Blog(Integer.parseInt(bid),user.getId());
                        if (DAOFactory.getBlogDAOInstance().findBlogByUidAndBid(blog)!=null){
                            DAOFactory.getBlogDAOInstance().removeBlogById(blog);
                            DAOFactory.getBlogClassificationDAOInstance().removeBlogClassification(new BlogClassification(user.getId(),blog.getId()));
                            code = 1;
                        }else {
                            error = error + "该博客不存在！；";
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
