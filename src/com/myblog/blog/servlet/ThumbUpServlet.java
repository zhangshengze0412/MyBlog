/**
 * @Title: ThumbUpServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 11:44 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.ThumbUp;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: ThumbUpServlet
 * @description: 实现添加/取消点赞功能
 * @author: ZSZ
 * @date: 2019/7/28 11:44
 */
@WebServlet(name = "ThumbUpServlet",urlPatterns = "/u/article/thumbup")
public class ThumbUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        boolean status = false;
        User user = null;
        Blog blog = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {

            String uid = request.getParameter("uid");
            String bid = request.getParameter("bid");
            String thumbup = request.getParameter("thumbup");
            user = (User) request.getSession().getAttribute(uid);

            if(ServletUtil.isNotNull(new String[]{uid,bid,thumbup})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        int blogId = Integer.parseInt(bid);
                        blog = DAOFactory.getBlogDAOInstance().findBlogById(new Blog(blogId));
                        if(blog != null){
                            ThumbUp thumbUp = new ThumbUp(user.getId(),blogId);
                            if("true".equals(thumbup)){
                                if(!DAOFactory.getThumbUpDAOInstance().findByUidAndBid(thumbUp)){
                                    if (DAOFactory.getThumbUpDAOInstance().addThumbUp(thumbUp)){
                                        blog.setThumbup(blog.getThumbup()+1);
                                        DAOFactory.getBlogDAOInstance().updateBlog(blog);
                                        code = 1;
                                        status = true;
                                    }else{
                                        error = error + "数据库存取错误！；";
                                    }
                                }else {
                                    error = error+"已对该文章点赞！；";
                                }

                            }else if ("false".equals(thumbup)){
                                if (DAOFactory.getThumbUpDAOInstance().findByUidAndBid(thumbUp)){
                                    DAOFactory.getThumbUpDAOInstance().removeByUidAndBid(thumbUp);
                                    blog.setThumbup(blog.getThumbup()-1);
                                    DAOFactory.getBlogDAOInstance().updateBlog(blog);
                                    code = 1;
                                }else{
                                    error = error + "已取消点赞！；";
                                }
                            }else {
                                code = -2;
                            }
                        }else{
                            error = error + "被点赞博客不存在！；";
                        }
                    }catch (NumberFormatException e){
                        code = -2;
                        e.printStackTrace();
                    } catch (Exception e){
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

        ServletUtil.responseOutWriter(out,code,status,error,blog);
    }
}
