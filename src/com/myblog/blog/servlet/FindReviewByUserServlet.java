/**
 * @Title: FindReviewByUserServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 13:22 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
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
 * @className: FindReviewByUserServlet
 * @description: 查询该用户的所有评论
 * @author: ZSZ
 * @date: 2019/7/28 13:21
 */
@WebServlet(name = "FindReviewByUserServlet",urlPatterns = "/u/findreview")
public class FindReviewByUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User user = null;
        List<Review> reviewList = null;
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
                        reviewList= DAOFactory.getReviewDAOInstance().findReviewListByUid(user);
                        code = 1;
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

        if ( request==null || reviewList.size()==0 ){
            ServletUtil.responseOutWriter(out,code,"total",0,error,"review");
        }else {
            ServletUtil.responseOutWriter(out,code,"total",reviewList.size(),error,ServletUtil.transformObjectList(reviewList));
        }
    }
}
