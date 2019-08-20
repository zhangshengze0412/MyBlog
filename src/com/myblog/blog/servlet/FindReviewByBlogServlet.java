/**
 * @Title: FFindReviewByBlogServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 13:28 PM
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
import java.util.List;

/**
 * @className: FindReviewByBlogServlet
 * @description: 查询该博客的所有评论
 * @author: ZSZ
 * @date: 2019/7/28 13:28
 */
@WebServlet(name = "FindReviewByBlogServlet",urlPatterns = "/findreview")
public class FindReviewByBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        List<Review> reviewList = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {
            String bid = request.getParameter("bid");
            if( bid != null && !"".equals(bid)){
                try{
                    reviewList = DAOFactory.getReviewDAOInstance().findReviewListByBid(new Blog(Integer.parseInt(bid)));
                    code = 1;
                }catch (NumberFormatException e){
                    code = -2;
                    e.printStackTrace();
                } catch (Exception e){
                    code = 0;
                    error = error + "服务端错误！；";
                    e.printStackTrace();
                }
            }else{
                code = -2;
            }
        }

        if ( reviewList==null || reviewList.size()==0 ){
            ServletUtil.responseOutWriter(out,code,"total",0,error,"review");
        }else {
            ServletUtil.responseOutWriter(out,code,"total",reviewList.size(),error,ServletUtil.transformObjectList(reviewList));
        }
    }
}
