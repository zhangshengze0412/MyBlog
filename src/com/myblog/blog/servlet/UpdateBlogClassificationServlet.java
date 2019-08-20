/**
 * @Title: UpdateBlogClassificationServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 20:06 PM
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
import java.util.Iterator;
import java.util.List;

/**
 * @className: UpdateBlogClassificationServlet
 * @description: 实现修改文章所属分类功能
 * @author: ZSZ
 * @date: 2019/7/28 20:05
 */
@WebServlet(name = "UpdateBlogClassificationServlet", urlPatterns = "/u/updateblogclassification")
public class UpdateBlogClassificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int all = 0;
        User user = null;
        List<String> classificationList = null;
        String error = "";
        PrintWriter out = response.getWriter();

        String uid = request.getParameter("uid");
        String bid = request.getParameter("bid");
        String classification = request.getParameter("classification");
        user = (User) request.getSession().getAttribute(uid);

        if(request.getAttribute("permissions")!=null) {
            return;
        }else {
            if(ServletUtil.isNotNull(new String[]{uid,bid,classification})){
                if (uid.equals(Integer.toString(user.getId()))){
                    try {
                        int blogId = Integer.parseInt(bid);
                        if(DAOFactory.getBlogDAOInstance().findBlogById(new Blog(blogId))!=null){
                            classificationList  = ServletUtil.transformStringList(classification);
                            if(DAOFactory.getBlogClassificationDAOInstance().removeBlogClassification(new BlogClassification(user.getId(),blogId))){
                                Iterator<String> it = classificationList.iterator();
                                code = 1;
                                while(it.hasNext()){
                                    String str = it.next();
                                    if(!"".equals(str)){
                                        if(!DAOFactory.getBlogClassificationDAOInstance().addBlogClassification(new BlogClassification(user.getId(),blogId,str))){
                                            code = 0;
                                            error = error + "数据库存取错误！；";
                                        }
                                    }
                                }
                            }else{
                                error = error + "数据库存取错误！；";
                            }
                        }else {
                            error = error+"该博客不存在！；";
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

            }else {
                code = -2;
            }

        }

        if ( classificationList==null || classificationList.size()==0 ){
            ServletUtil.responseOutWriter(out,code,"total",0,error,"classification");
        }else {
            ServletUtil.responseOutWriter(out,code,"total",classificationList.size(),error,classificationList);
        }
    }
}
