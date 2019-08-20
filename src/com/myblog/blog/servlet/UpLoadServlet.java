/**
 * @Title: UpLoadServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 8:30 AM
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
 * @className: UpLoadServlet
 * @description: 博客上传
 * @author: ZSZ
 * @date: 2019/7/28 8:29
 */
@WebServlet(name = "UpLoadServlet",urlPatterns = "/u/article/upload")
public class UpLoadServlet extends HttpServlet {
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
            String title = request.getParameter("title");
            String context = request.getParameter("context");
            String classification = request.getParameter("classification");
            User user = (User) request.getSession().getAttribute(uid);

            if (ServletUtil.isNotNull(new String[]{uid,title,context,classification})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        if (DAOFactory.getBlogDAOInstance().findBlogByTitle(new Blog(title))==null){
                            blog = new Blog(user.getId(),title,user.getUsername(),new Date(),context,0,0);
                            DAOFactory.getBlogDAOInstance().addBlog(blog);
                            newBlog = DAOFactory.getBlogDAOInstance().findBlogByTitle(new Blog(title));
                            if(newBlog != null){
                                code = 1;
                                List<String> list = ServletUtil.transformStringList(classification);
                                Iterator<String> it = list.iterator();
                                while(it.hasNext()){
                                    String str = it.next();
                                    if(!str.equals("")){
                                        if(!DAOFactory.getBlogClassificationDAOInstance().addBlogClassification(new BlogClassification(user.getId(),newBlog.getId(),str))){
                                            code = 0;
                                            error = error + "数据库存取错误！；";
                                        }
                                    }
                                }
                            }else{
                                error = error + "数据库存取错误！；";
                            }
                        }else {
                            error = error + "该博客已存在，请重命名！；";
                        }
                    }catch (Exception e){
                        code = 0;
                        error = error + "服务端错误！；";
                    }
                }else {
                    code =-2;
                }
            }else{
                code = -2;
            }

            ServletUtil.responseOutWriter(out,code,error,newBlog);
        }


    }
}
