/**
 * GitHub address:
 * @Title: Review.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/23 20:33 PM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

import java.util.Date;

/**
 * @className Review
 * @description 封装评论对象数据
 * @author ZSZ
 * @data 2019/7/23 20:33 PM
 */
public class Review {
    private int id;
    private int uid;
    private int bid;
    private String context;
    private Date time;

    public Review(){}

    public Review(int id){
        this.id = id;
    }

    public Review(int uid, int bid, String context){
        this.uid = uid;
        this.bid = bid;
        this.context = context;
    }

    public Review(int uid, int bid, String context,Date time){
        this.uid = uid;
        this.bid = bid;
        this.context = context;
        this.time = time;
    }

    public Review(int id, int uid, int bid, String context,Date time){
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.context = context;
        this.time = time;
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

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
