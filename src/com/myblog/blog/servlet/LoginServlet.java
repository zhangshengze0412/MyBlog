/**
 * @Title: LoginServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/26 23:33 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.JSONUtil;
import com.myblog.blog.util.ServletUtil;
import com.myblog.blog.vo.User;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: LoginServlet
 * @description: 登录
 * @author: ZSZ
 * @date: 2019/7/26 23:32 PM
 */
@WebServlet(urlPatterns ="/login",name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int code = 0;
        User user = null;
        String error = "";
        PrintWriter out = response.getWriter();
        String uid = request.getParameter("uid");
        String password = request.getParameter("password");
        String verificode = request.getParameter("verificode");
        System.out.println("LoginServlet-------sessionID:"+request.getSession().getId());
        String VerifyCode = (String)request.getSession().getAttribute("VerifyCode");

        if(verificode == null || VerifyCode == null || "".equals(code) || !VerifyCode.equals(verificode)){
            System.out.println("VerifyCode:"+VerifyCode);
            error = error+"验证码输入错误！！！；";
        } else {
            if ( uid==null || "".equals(uid)){
                error = error +"ID不能为空！；";
            }else {
                if ( password==null || "".equals(password)){
                    error = error +"密码不能为空！；";
                }else {
                    try{
                       User u = new User(Integer.parseInt(uid),password);
                        if(DAOFactory.getUserDAOInstance().findUserById(u) != null){
                            user = DAOFactory.getUserDAOInstance().checkLogin(u);
                            if (user != null){
                                request.getSession().setAttribute(uid,user);
                                code = 1;
                            }else {
                                error = error + "密码错误！；";
                            }
                        }else {
                            error = error + "ID输入错误！此用户不存在，请先注册！；";
                        }
                    } catch (NumberFormatException e){
                        error = error + "传入参数错误！；";
                        code = -2;
                    } catch (Exception e){
                        code =0;
                        error = error + "服务端错误！；";
                        e.printStackTrace();
                    }
                }
            }
        }

        ServletUtil.responseOutWriter(out,code,error,user);
    }
}
