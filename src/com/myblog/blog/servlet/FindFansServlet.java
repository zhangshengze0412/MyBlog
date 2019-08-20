/**
 * @Title: FindFansServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 20:51 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.util.ServletUtil;
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
 * @className: FindFansServlet
 * @description: 查询关注该用户的所有用户
 * @author: ZSZ
 * @date: 2019/7/28 20:51
 */
@WebServlet(name = "FindFansServlet", urlPatterns = "/u/findfans")
public class FindFansServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int num = 0;
        User user = null;
        List<User> attentionUser = new ArrayList<>();
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
                        List<Integer> list= DAOFactory.getAttentionDAOInstance().findFansListByUid(user);
                        code = 1;
                        if(list != null){
                            Iterator<Integer> it = list.iterator();
                            while (it.hasNext()){
                                User user1 = DAOFactory.getUserDAOInstance().findUserById(new User(it.next()));
                                if(user1 != null){
                                    attentionUser.add(user1);
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

        if(attentionUser==null || attentionUser.size()==0){
            ServletUtil.responseOutWriter(out,code,"fans",0,error,"user");
        }else {
            ServletUtil.responseOutWriter(out,code,"fans",attentionUser.size(),error,ServletUtil.transformObjectList(attentionUser));
        }
    }
}
