/**
 * @Title: CreateverifyCode.java
 * @Package com.myblog.blog.util
 * @Description: 工具包
 * @author: ZSZ
 * @date: 2019/7/26 23:23 PM
 * @version 1.0
 *
 */
package com.myblog.blog.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @className: CreateverifyCode
 * @description: 创建验证码图片及内容
 * @author: ZSZ
 * @date: 2019/7/26 23:23 PM
 */
public class CreateVerifyCode {

    //定义验证码框的长宽
    private int length = 80;
    private int height = 32;

    // 定义可选字体{"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
    //private String[] fontNames  = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};

    // 可选字符
    private String codes  = "0123456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    //验证码内容
    private String verifyCode;

    private BufferedImage image;

    private Random random = new Random();

    public CreateVerifyCode(){
        createBufferedImage();
    }

    /**
     * @description 随机生成颜色
     * @return Color
     */
    private Color randomColor(){
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red,green,blue);
    }

    /**
     * @description 随机生成字体
     * @return Font
     */
    private Font randomFont(){
//        int index = random.nextInt(fontNames.length);
//        String fontName = fontNames[index];                     //生成随机的字体名称
//        int style = random.nextInt(4);                   //生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int size = random.nextInt(5) + 24;               //生成随机字号, 24 ~ 28
        return new Font("DejaVu Sans Mono",0, size);
    }

    /**
     * @description 绘制60条干扰线条
     * @param image
     */
    private void drawLine(BufferedImage image){

        Graphics g2 = image.createGraphics();

        //画60条干扰线条
        for (int i = 0; i < 5 ; i++) {
            //干扰线条的起始点
            int beginX = random.nextInt(length);
            int beginY = random.nextInt(height);
            int endX = random.nextInt(length);
            int endY = random.nextInt(height);
            g2.setColor(randomColor());                         //干扰线条的颜色随机生成
            g2.drawLine(beginX,beginY,endX,endY);               //划线
        }
    }

    /**
     * @description 随机生成4位验证码字符
     * @return String 验证码字符
     */
    private String createVerifyCode(){
        StringBuffer buffer = new StringBuffer();
        //随机生成4个字符
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(codes.length());
            char code = codes.charAt(index);
            buffer.append(code);
        }
        return buffer.toString();
    }

    /**
     * @description 获取验证码值
     * @return String 验证码值
     */
    public String getVerifyCode(){
        return verifyCode;
    }

    /**
     * @description 创建验证码图片
     */
    private void createBufferedImage(){
        image = new BufferedImage(length,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, length, height);
        verifyCode = createVerifyCode();                            //创建验证码
        for (int i = 0; i <verifyCode.length(); i++) {              //绘制验证码
            float x = i * 1.0F * length / 4;                        //设置当前字符的x轴坐标
            g.setFont(randomFont());                               //设置字体
            g.setColor(randomColor());
            g.drawString(""+verifyCode.charAt(i),(int)x,height-5);
        }
        drawLine(image);

    }

    /**
     * @description 返回验证码图片
     * @return BufferedImage 验证码图片
     */
    public BufferedImage getVerifyCodeImage(){
        return  image;
    }
}
