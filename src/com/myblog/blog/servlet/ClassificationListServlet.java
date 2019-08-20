/**
 * @Title: ClassificationListServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 14:35 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.JSONUtil;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Review;
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
 * @className: ClassificationListServlet
 * @description: 返回该用户所有已有类别
 * @author: ZSZ
 * @date: 2019/7/28 14:35
 */
@WebServlet(name = "ClassificationListServlet" ,urlPatterns = "/classificationlist")
public class ClassificationListServlet extends HttpServlet {
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

        if(request.getAttribute("permissions")!=null) {
            return;
        }else {
            if(uid != null && !"".equals(uid)){
                try {
                    int userID = Integer.parseInt(uid);
                    classificationList = DAOFactory.getBlogClassificationDAOInstance().findBlogClassificationListByUid(new User(uid));
                    code = 1;
                }catch (NumberFormatException e){
                    code = -2;
                }catch (Exception e){
                    code = 0;
                    error = error + "服务端错误！；";
                }
            }else {
                code = -2;
            }
        }

        if ( classificationList==null||classificationList.size()==0){
            ServletUtil.responseOutWriter(out,code,"total",0,error,"classification");
        }else {
            ServletUtil.responseOutWriter(out,code,"total",classificationList.size(),error,ServletUtil.transformStringArray(classificationList));
        }
    }
}
