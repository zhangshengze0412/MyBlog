/**
 * GitHub address:
 * @Title: JSONUtil.java
 * @Package com.myblog.blog.util
 * @Description: 工具包
 * @author: ZSZ
 * @date: 2019/7/27 10:30 AM
 * @version 1.0
 *
 */
package com.myblog.blog.util;

import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
import com.myblog.blog.vo.User;
import org.json.JSONObject;

import java.util.List;


/**
 * @className: JSONUtil
 * @description: JSON工具类，方便操作
 * @author: ZSZ
 * @date: 2019/7/27 10:29
 */
public class JSONUtil {

    /**
     * @description 将List数组，转成JSONObject数组
     * @param obj
     * @return
     */
    private static JSONObject[] transformJSONArray(Object[] obj){
        if (obj == null || obj.length==0){
            return null;
        }else {
            JSONObject[] object = new JSONObject[obj.length];
            for (int i = 0; i<obj.length; i++){
                object[i] = new JSONObject(obj[i]);
            }
            return object;
        }
    }

    /**
     * @description 将JSON数组转为字符串
     * @param obj
     * @return
     */
    private static String transformToString(JSONObject[] obj){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i < obj.length-1 ; i++) {
            buffer.append(obj[i].toString()+",");
        }
        buffer.append(obj[obj.length-1].toString()+"]");
        return buffer.toString();
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param error
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,String error){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put("error",error);
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param name
     * @param num
     * @param className
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,String name,int num,String className){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put(name,num);
        jsonObject.put(className,JSONObject.NULL);
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param obj
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,Object obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        if (obj instanceof User){
            jsonObject.put("user",new JSONObject(obj));
        }else if(obj instanceof Blog){
            jsonObject.put("article",new JSONObject(obj));
        }else if(obj instanceof Review){
            jsonObject.put("review",new JSONObject(obj));
        }
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param name
     * @param num
     * @param obj
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,String name,int num,Object obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put(name,num);
        if (obj instanceof User){
            jsonObject.put("user",new JSONObject(obj));
        }else if(obj instanceof Blog){
            jsonObject.put("article",new JSONObject(obj));
        }else if(obj instanceof Review){
            jsonObject.put("review",new JSONObject(obj));
        }
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param name
     * @param num
     * @param obj
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,String name,int num,Object[] obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put(name,num);
        if (obj[0] instanceof User){
            jsonObject.put("user",transformJSONArray(obj));
        }else if (obj[0] instanceof Blog){
            jsonObject.put("article",transformJSONArray(obj));
        }else if (obj[0] instanceof Review){
            jsonObject.put("review",transformJSONArray(obj));
        }
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param name
     * @param num
     * @param obj
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,String name,int num,String[] obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put(name,num);
        jsonObject.put("classification",obj);
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param status
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,boolean status,Object obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put("status",status);
        if (obj instanceof User){
            jsonObject.put("user",new JSONObject(obj));
        }else if(obj instanceof Blog){
            jsonObject.put("article",new JSONObject(obj));
        }else if(obj instanceof Review){
            jsonObject.put("review",new JSONObject(obj));
        }
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param all
     * @param currentpage
     * @param total
     * @param record
     * @param obj
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,int all,int currentpage,int record,int total,Object[] obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put("all",all);
        jsonObject.put("currentpage",currentpage);
        jsonObject.put("total",total);
        jsonObject.put("record",record);
        if (obj[0] instanceof User){
            jsonObject.put("user",transformJSONArray(obj));
        }else if (obj[0] instanceof Blog){
            jsonObject.put("article",transformJSONArray(obj));
        }else if (obj[0] instanceof Review){
            jsonObject.put("review",transformJSONArray(obj));
        }
        return jsonObject;
    }

    /**
     * @description 为JSONObject设置值，并返回
     * @param code
     * @param msg
     * @param all
     * @param currentpage
     * @param total
     * @param record
     * @param className
     * @return
     */
    public static JSONObject setParameterForJson(int code,String msg,int all,int currentpage,int record,int total,String className){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put("all",all);
        jsonObject.put("currentpage",currentpage);
        jsonObject.put("total",total);
        jsonObject.put("record",record);
        jsonObject.put(className,JSONObject.NULL);
        return jsonObject;
    }



}
