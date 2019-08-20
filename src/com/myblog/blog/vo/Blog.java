/**
 * GitHub address:
 * @Title: Blog.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/23 20:11 PM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

import java.util.Date;

/**
 * @className Blog
 * @description 封装文章对象数据
 * @author ZSZ
 * @data 2019/7/23 20:22 PM
 */
public class Blog {
    private int id;
    private int uid;
    private String title;
    private String author;
    private Date time;
    private String context;
    private int see;
    private int thumbup;

    public Blog(){}

    public Blog(int id){ this.id = id; }

    public Blog(String title){
        this.title = title;
    }

    public Blog(int id,int uid){
        this.id = id;
        this.uid = uid;
    }

    public Blog(int uid,String title){
        this.uid = uid;
        this.title = title;
    }

    public Blog(String title,String author,String context){
        this.title = title;
        this.author = author;
        this.context = context;
    }

    public Blog(int uid, String title, String author, Date time, String context, int see, int thumbup){
        this.uid = uid;
        this.title = title;
        this.author = author;
        this.time = time;
        this.context = context;
        this.see = see;
        this.thumbup = thumbup;
    }

    public Blog(int id, int uid, String title, String author, Date time, String context, int see, int thumbup){
        this.id = id;
        this.uid = uid;
        this.title = title;
        this.author = author;
        this.time = time;
        this.context = context;
        this.see = see;
        this.thumbup = thumbup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getSee() {
        return see;
    }

    public void setSee(int see) {
        this.see = see;
    }

    public int getThumbup() {
        return thumbup;
    }

    public void setThumbup(int thumbup) {
        this.thumbup = thumbup;
    }
}
