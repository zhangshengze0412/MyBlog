/**
 * GitHub address:
 * @Title: JSONUtil.java
 * @Package com.myblog.blog.util
 * @Description: 工具包
 * @author: ZSZ
 * @date: 2019/7/27 14:11 PM
 * @version 1.0
 *
 */
package com.myblog.blog.util;

import com.myblog.blog.vo.User;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @className: ServletUtil
 * @description: Servlet工具类
 * @author: ZSZ
 * @date: 2019/7/27 14:10
 */
public class ServletUtil {

    /**
     * 将List<String>转成String【】
     * @param list
     * @return
     */
    public static  String[] transformStringArray(List<String> list){
        String[] objects = new String[list.size()];
        for (int i = 0; i <list.size(); i++) {
            objects[i] = list.get(i);
        }
        return objects;
    }

    /**
     * @description 将用“，”逗号风隔的字符串转为List
     * @param str
     * @return
     */
    public static List<String> transformStringList(String str){
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ','){
                list.add(str.substring(index,i));
                index = i+1;
            }
        }
        list.add(str.substring(index,str.length()));
        return list;
    }

    /**
     * @description 将ArrayList数组转成数组对象
     * @param list
     * @return
     */
    public static Object[] transformObjectList(List list){
        if (list.size() == 0){
            return null;
        }else{
            Object[] obj = new Object[list.size()];
            for (int i = 0; i < list.size(); i++) {
                obj[i] = list.get(i);
            }
            return obj;
        }

    }

    /**
     * 判断传入的参数数组是否存在null
     * @param str
     * @return
     */
    public static boolean isNotNull(String[] str){
        boolean flag = true;
        for (int i = 0; i < str.length ; i++) {
            Object temp = str[i];
            if(temp == null || "".equals(temp)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param error
     * @param object
     */
    public static void responseOutWriter(PrintWriter out, int code,String error, Object object){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,object);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param status
     * @param error
     * @param object
     */
    public static void responseOutWriter(PrintWriter out, int code,boolean status,String error, Object object){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,status,object);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param error
     */
    public static void responseOutWriter(PrintWriter out, int code,String error){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param name
     * @param num
     * @param error
     */
    public static void responseOutWriter(PrintWriter out, int code,String name,int num,String error){
        String msg;
        JSONObject obj;
        if(code == 1){
            obj = new JSONObject();
            msg = "success";
            obj.put("code",code);
            obj.put("msg",msg);
            obj.put(name,num);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param name
     * @param num
     * @param error
     * @param object
     */
    public static void responseOutWriter(PrintWriter out, int code,String name,int num,String error, Object[] object){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,name,num,object);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param name
     * @param num
     * @param error
     * @param object
     */
    public static void responseOutWriter(PrintWriter out, int code,String name,int num,String error, String[] object){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,name,num,object);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param name
     * @param num
     * @param error
     * @param list
     */
    public static void responseOutWriter(PrintWriter out, int code,String name,int num,String error, List<String> list){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,name,num,list);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param name
     * @param num
     * @param error
     * @param className
     */
    public static void responseOutWriter(PrintWriter out, int code,String name,int num,String error,String className){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,name,num,className);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param status
     * @param error
     * @param object
     */
    public static void responseOutWriter(PrintWriter out, int code,boolean status,String error, Object[] object){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,status,object);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param all
     * @param currentpage
     * @param recode
     * @param total
     * @param error
     * @param object
     */
    public static void responseOutWriter(PrintWriter out, int code,int all,int currentpage,int recode,int total, String error, Object[] object){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,all,currentpage,recode,total,object);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

    /**
     * @description 向PrintWriter中写入数据
     * @param out
     * @param code
     * @param all
     * @param currentpage
     * @param recode
     * @param total
     * @param error
     * @param className
     */
    public static void responseOutWriter(PrintWriter out, int code,int all,int currentpage,int recode,int total, String error, String className){
        String msg;
        JSONObject obj;
        if(code == 1){
            msg = "success";
            obj = JSONUtil.setParameterForJson(code,msg,all,currentpage,recode,total,className);
            out.write(obj.toString());
        }else if(code == 0){
            msg = "failed";
            obj = JSONUtil.setParameterForJson(code,msg,error);
            out.write(obj.toString());
        }else if (code == -1){
            msg = "insufficient permissions";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }else if(code == -2){
            msg = "param error";
            obj = JSONUtil.setParameterForJson(code,msg);
            out.write(obj.toString());
        }
    }

}
