/**
 * @Title: VerifyCodeServlet.java
 * @Package com.myblog.blog.servle
 * @Description: servlet
 * @author: ZSZ
 * @date: 2019/7/26 23:25 PM
 * @version 1.0
 *
 */
package com.myblog.blog.servlet;

import com.myblog.blog.util.CreateVerifyCode;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @className: VerifyCodeServlet
 * @description: 验证码
 * @author: ZSZ
 * @date: 2019/7/26 23:25
 */
@WebServlet(urlPatterns = "/verificode",name = "VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("image/jpeg");

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);

        CreateVerifyCode verifyCode = new CreateVerifyCode();
        String code = verifyCode.getVerifyCode();
        BufferedImage image = verifyCode.getVerifyCodeImage();

        ImageIO.write(image,"JPEG",response.getOutputStream());

//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ImageIO.write(image,"png",outputStream);
//        String imagestr =new String(Base64.encodeBase64(outputStream.toByteArray()));
//        if(imagestr!=null && !"".equals(imagestr)){
//            JSONObject object = new JSONObject();
//            object.put("code",1);
//            object.put("msg","success");
//            object.put("image",imagestr);
//            response.getWriter().write(object.toString());
//        }else {
//            JSONObject object = new JSONObject();
//            object.put("code",0);
//            object.put("msg","failed");
//            object.put("error","验证码异常");
//            response.getWriter().write(object.toString());
//        }


        request.getSession().setAttribute("VerifyCode",code);
        System.out.println("VerifyCode-------sessionID:"+request.getSession().getId());
        System.out.println(code);
    }
}
