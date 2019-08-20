/**
 * @Title: UpDateBlogServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 15:42 PM
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
 * @className: UpDateBlogServlet
 * @description: 修改博客并上传
 * @author: ZSZ
 * @date: 2019/7/28 15:42
 */
@WebServlet(name = "UpDateBlogServlet",urlPatterns = "/u/article/updateblog")
public class UpDateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        Blog blog ;
        Blog newBlog = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {

            String uid = request.getParameter("uid");
            String bid = request.getParameter("bid");
            String title = request.getParameter("title");
            String context = request.getParameter("context");
            User user = (User) request.getSession().getAttribute(uid);


            if (ServletUtil.isNotNull(new String[]{uid,bid,title,context})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        blog = DAOFactory.getBlogDAOInstance().findBlogById(new Blog(Integer.parseInt(bid)));
                        if (blog!=null){
                            if(DAOFactory.getBlogDAOInstance().findBlogByUidAndTitle(new Blog(user.getId(),title))==null){
                                newBlog = new Blog(blog.getId(),title,user.getUsername(),blog.getTime(),context,blog.getSee(),blog.getThumbup());
                                DAOFactory.getBlogDAOInstance().updateBlog(newBlog);
                                code =1;
                            }else {
                                error = error + "该标题已存在，请重命名！；";
                            }
                        }else {
                            error = error + "该博客不存在！；";
                        }
                    }catch (NumberFormatException e){
                        code = -2;
                    }catch (Exception e){
                        code = 0;
                        error = error + "服务端错误！；";
                    }
                }else{
                    code = -2;
                }
            }else{
                code = -2;
            }

            ServletUtil.responseOutWriter(out,code,error,newBlog);
        }


    }
}
