/**
 * @Title: AttentionServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 10:25 AM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: AttentionServlet
 * @description: 添加/取消关注
 * @author: ZSZ
 * @date: 2019/7/28 10:24
 */
@WebServlet(name = "AttentionServlet",urlPatterns ="/u/attention")
public class AttentionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        boolean status = false;
        User user = null;
        User attentionUser = null;
        String error = "";
        PrintWriter out = response.getWriter();

        if (request.getAttribute("permissions")!=null){
            return;
        }else {

            String uid = request.getParameter("uid");
            String aid = request.getParameter("aid");
            String attention = request.getParameter("attention");
            user = (User) request.getSession().getAttribute(uid);

            if(ServletUtil.isNotNull(new String[]{uid,aid,attention})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try{
                        int atttentionId = Integer.parseInt(aid);
                        attentionUser = DAOFactory.getUserDAOInstance().findUserById(new User(atttentionId));
                        if(attentionUser != null){
                            Attention attentionRecord = new Attention(user.getId(),atttentionId);
                            if("true".equals(attention)){
                                if(!DAOFactory.getAttentionDAOInstance().findByUidAndAid(attentionRecord)){
                                    if (DAOFactory.getAttentionDAOInstance().addAttention(attentionRecord)){
                                        code = 1;
                                        status = true;
                                    }else{
                                        error = error + "数据库存取错误！；";
                                    }
                                }else {
                                    error = error + "已关注该用户！；";
                                }

                            }else if ("false".equals(attention)){
                                if (DAOFactory.getAttentionDAOInstance().findByUidAndAid(attentionRecord)){
                                    DAOFactory.getAttentionDAOInstance().removeByUidAndAid(attentionRecord);
                                    code = 1;
                                }else{
                                    error = error + "已取消关注！；";
                                }
                            }else {
                                code = -2;
                            }
                        }else{
                            error = error + "被关注用户不存在！；";
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

        ServletUtil.responseOutWriter(out,code,status,error,attentionUser);
    }
}
