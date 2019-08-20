/**
 * @Title: CollectServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 11:54 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Collection;
import com.myblog.blog.vo.ThumbUp;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

/**
 * @className: CollectServlet
 * @description: 实现添加/取消收藏功能
 * @author: ZSZ
 * @date: 2019/7/28 11:54
 */
@WebServlet(name = "CollectServlet",urlPatterns ="/u/article/collect")
public class CollectServlet extends HttpServlet {
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
            String collect = request.getParameter("collect");
            user = (User) request.getSession().getAttribute(uid);

            if(ServletUtil.isNotNull(new String[]{uid,bid,collect})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        int blogId = Integer.parseInt(bid);
                        blog = DAOFactory.getBlogDAOInstance().findBlogById(new Blog(blogId));
                        if(blog != null){
                            Collection collection = new Collection(user.getId(),blogId);
                            if("true".equals(collect)){
                                if(!DAOFactory.getCollectionDAOInstance().findByUidAndBid(collection)){
                                    if (DAOFactory.getCollectionDAOInstance().addCollection(collection)){
                                        code = 1;
                                        status = true;
                                    }else{
                                        error = error + "数据库存取错误！；";
                                    }
                                }else {
                                    error = error + "已收藏该文章！；";
                                }

                            }else if ("false".equals(collect)){
                                if (DAOFactory.getCollectionDAOInstance().findByUidAndBid(collection)){
                                    DAOFactory.getCollectionDAOInstance().removeByUidAndBid(collection);
                                    code = 1;
                                }else{
                                    error = error + "已取消收藏！；";
                                }
                            }else {
                                code = -2;
                            }
                        }else{
                            error = error + "被收藏博客不存在！；";
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
