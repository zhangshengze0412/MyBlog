/**
 * @Title: FindUserListServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/28 13:47 PM
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
import java.util.List;

/**
 * @className: FindUserListServlet
 * @description: 查询所有用户（分页显示）
 * @author: ZSZ
 * @date: 2019/7/28 13:47
 */
@WebServlet(name = "FindUserListServlet" ,urlPatterns = "/admin/finduserlist")
public class FindUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        int all = 0;
        User user = null;
        List<User> userList = null;
        String error = "";
        PrintWriter out = response.getWriter();
        int currentpageint = 0;
        int recordint = 0;

        String uid = request.getParameter("uid");
        String currentpage = request.getParameter("currentpage");
        String record = request.getParameter("record");
        user = (User) request.getSession().getAttribute(uid);

        if(request.getAttribute("permissions")!=null) {
            return;
        }else {
            if(ServletUtil.isNotNull(new String[]{uid,currentpage,record})){
                if(uid.equals(Integer.toString(user.getId()))){
                    try {
                        currentpageint = Integer.parseInt(currentpage);
                        recordint = Integer.parseInt(record);
                        all = DAOFactory.getUserDAOInstance().findUserNum();
                        userList = DAOFactory.getUserDAOInstance().findUser(currentpageint,recordint);
                        code = 1;
                    }catch (NumberFormatException e){
                        code = -2;
                        e.printStackTrace();
                    } catch (Exception e){
                        code = 0;
                        error = error + "服务端错误！；";
                    }
                }else {
                    code =-2;
                }

            }else{
                code = -2;
            }
        }

        if (userList==null || userList.size()==0){
            ServletUtil.responseOutWriter(out,code,0,currentpageint,0,recordint==0?0:
                    all%recordint==0?all/recordint:all/recordint+1,error,"user");
        }else {
            ServletUtil.responseOutWriter(out,code,all,currentpageint,userList.size(),
                    all%recordint==0?all/recordint:all/recordint+1,error,ServletUtil.transformObjectList(userList));
        }
    }
}
