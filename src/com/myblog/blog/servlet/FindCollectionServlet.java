/**
 * @Title: FindCollectionServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 12：03 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Collection;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @className: FindCollectionServlet
 * @description: 查询该用户已收藏的所有文章
 * @author: ZSZ
 * @date: 2019/7/28 12:03
 */
@WebServlet(name = "FindCollectionServlet",urlPatterns = "/u/findcollection")
public class FindCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User user = null;
        List<Blog> blogList = new ArrayList<>();
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {

            String uid = request.getParameter("uid");
            user = (User) request.getSession().getAttribute(uid);
            if( uid != null && !"".equals(uid)){
                try{
                    if (user.getId() == Integer.parseInt(uid)){
                        List<Integer> list= DAOFactory.getCollectionDAOInstance().findCollectionListByUid(user);
                        code = 1;
                        if(list != null){
                            blogList = new ArrayList<>();
                            Iterator<Integer> it = list.iterator();
                            while (it.hasNext()){
                                Blog blog = DAOFactory.getBlogDAOInstance().findBlogById(new Blog(it.next()));
                                if(blog != null){
                                    blogList.add(blog);
                                }
                            }
                        }
                    }else{
                        code = -2;
                    }
                }catch (NumberFormatException e){
                    code = -2;
                    e.printStackTrace();
                } catch (Exception e){
                    code = 0;
                    error = error + "服务端错误！；";
                }
            }else{
                code = -2;
            }
        }

        if ( blogList==null || blogList.size()==0 ){
            ServletUtil.responseOutWriter(out,code,"collection",0,error,"blog");
        }else {
            ServletUtil.responseOutWriter(out,code,"collection",blogList.size(),error,ServletUtil.transformObjectList(blogList));
        }
    }
}
