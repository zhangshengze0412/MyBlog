/**
 * @Title: FindBlogsServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/27 0:18 AM
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
import java.util.List;

/**
 * @className: FindBlogsServlet
 * @description: 实现根据关键字搜索操作
 * @author: ZSZ
 * @date: 2019/7/28 0:17
 */
@WebServlet(name = "FindBlogsServlet",urlPatterns = "/findblogs")
public class FindBlogsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        List<Blog> blogList = null;
        String error = "";
        PrintWriter out = response.getWriter();

        String key = request.getParameter("key");
        if(key!=null && !"".equals(key)){
            try {
                blogList = DAOFactory.getBlogDAOInstance().findBlogListByKey(key);
                code = 1;
            } catch (Exception e){
                code = 0;
                error = error + "服务端错误！；";
                e.printStackTrace();
            }
        }else {
            code = -2;
        }

        if ( blogList==null || blogList.size()==0 ){
            ServletUtil.responseOutWriter(out,code,"record",0,error,"blog");
        }else {
            ServletUtil.responseOutWriter(out,code,"record",blogList.size(),error,ServletUtil.transformObjectList(blogList));
        }
    }
}
