/**
 * @Title: BlogListByTimeServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/27 22:01 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.JSONUtil;
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
 * @className: BlogListByTimeServlet
 * @description: 实现分页显示文章功能按时间排序
 * @author: ZSZ
 * @date: 2019/7/27 22:01
 */
@WebServlet(name = "BlogListByTimeServlet",urlPatterns = "/bloglistbytime")
public class BlogListByTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int all = 0;
        List<Blog> blogList = null;
        String error = "";
        PrintWriter out = response.getWriter();

        String currentpage = request.getParameter("currentpage");
        String record = request.getParameter("record");

        int currentpageint = 0;
        int recordint = 0;

        if (ServletUtil.isNotNull(new String[]{currentpage,record})){
            try {
                currentpageint = Integer.parseInt(currentpage);
                recordint = Integer.parseInt(record);
                all = DAOFactory.getBlogDAOInstance().findBlogNum();
                blogList = DAOFactory.getBlogDAOInstance().findBlogListByTime(currentpageint,recordint);
                code = 1;
            } catch (NumberFormatException e){
                code = -2;
                e.printStackTrace();
            } catch (Exception e){
                code = 0;
                error = error + "服务端错误！；";
                e.printStackTrace();
            }
        }else {
            code = -2;
        }

        if (blogList==null || blogList.size()==0){
            ServletUtil.responseOutWriter(out,code,0,currentpageint,0,
                    recordint==0 ? 0:all%recordint==0?all/recordint:all/recordint+1,error,"article");
        }else {
            ServletUtil.responseOutWriter(out,code,all,currentpageint,blogList.size(),
                    all%recordint==0?all/recordint:all/recordint+1,error,ServletUtil.transformObjectList(blogList));
        }

    }
}
