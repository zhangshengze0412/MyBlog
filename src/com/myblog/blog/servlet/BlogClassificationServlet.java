/**
 * @Title: BlogClassificationServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 14:59 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.BlogClassification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: BlogClassificationServlet
 * @description: 根据用户ID、文章ID查询该文章所属类别
 * @author: ZSZ
 * @date: 2019/7/28 14:58
 */
@WebServlet(name = "BlogClassificationServlet",urlPatterns = "/blogclassification")
public class BlogClassificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int all = 0;
        List<String> classificationList = null;
        String error = "";
        PrintWriter out = response.getWriter();

        String uid = request.getParameter("uid");
        String bid = request.getParameter("bid");

        if(request.getAttribute("permissions")!=null) {
            return;
        }else {
            if(ServletUtil.isNotNull(new String[]{uid,bid})){
                try {
                    Blog blog = DAOFactory.getBlogDAOInstance().findBlogById(new Blog(Integer.parseInt(bid)));
                    if(blog != null){
                        classificationList = DAOFactory.getBlogClassificationDAOInstance().findBlogClassificationByBid(new BlogClassification(Integer.parseInt(uid),blog.getId()));
                        code = 1;
                    }else {
                        error = error +"此博客不存在！；";
                    }
                } catch (NumberFormatException e){
                    code = -2;
                }catch (Exception e){
                    code = 0;
                    error = error + "服务端错误！；";
                }
            }else {
                code = -2;
            }

        }

        if (classificationList==null || classificationList.size()==0){
            ServletUtil.responseOutWriter(out,code,"total",0,error,"classification");
        }else {
            ServletUtil.responseOutWriter(out,code,"total",classificationList.size(),error,ServletUtil.transformStringArray(classificationList));
        }
    }
}
