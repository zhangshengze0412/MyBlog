/**
 * @Title: FindBlogByClassificationServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 15:09 PM
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @className: FindBlogByClassificationServlet
 * @description: 根据类别查询文章，返回属于该类的所有文章（分页显示）
 * @author: ZSZ
 * @date: 2019/7/28 15:09
 */
@WebServlet(name = "FindBlogByClassificationServlet",urlPatterns = "/findblogbyclassification")
public class FindBlogByClassificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int all = 0;
        List<Blog> blogList = new ArrayList<>();
        String error = "";
        PrintWriter out = response.getWriter();

        int currentpageint = 0;
        int recordint = 0;

        String uid = request.getParameter("uid");
        String classification = request.getParameter("classification");
        String currentpage = request.getParameter("currentpage");
        String record = request.getParameter("record");

        if (ServletUtil.isNotNull(new String[]{uid,classification,currentpage,record})){
            try {
                int userID = Integer.parseInt(uid);
                currentpageint = Integer.parseInt(currentpage);
                recordint = Integer.parseInt(record);
                BlogClassification blogClassification = new BlogClassification(userID,classification);
                all = DAOFactory.getBlogClassificationDAOInstance().findBlogNumByClassification(blogClassification);
                List<Integer> list = DAOFactory.getBlogClassificationDAOInstance().findBlogByClassification(currentpageint,recordint,blogClassification);
                code = 1;
                if(list != null){
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()){
                        Blog blog = DAOFactory.getBlogDAOInstance().findBlogById(new Blog(it.next()));
                        if(blog != null){
                            blogList.add(blog);
                        }
                    }
                }
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

        if ( blogList==null || blogList.size()==0 ){
            ServletUtil.responseOutWriter(out,code,0,currentpageint,0,recordint==0 ? 0:
                    all%recordint==0?all/recordint:all/recordint+1,error,"article");
        }else {
            ServletUtil.responseOutWriter(out,code,all,currentpageint,blogList.size(),
                    all%recordint==0?all/recordint:all/recordint+1,error,ServletUtil.transformObjectList(blogList));
        }
    }
}
