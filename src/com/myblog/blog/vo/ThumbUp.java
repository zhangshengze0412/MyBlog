/**
 * GitHub address:
 * @Title: ThumbUp.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/25 8:19 AM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

/**
 * @className ThumbUp
 * @description 封装数据库点赞表数据
 * @author ZSZ
 * @data 2019/7/23 20:12 AM
 */
public class ThumbUp {
    private int id;
    private int uid;
    private int bid;

    public ThumbUp(){}

    public ThumbUp(int uid,int bid){
        this.uid = uid;
        this.bid = bid;
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
}
