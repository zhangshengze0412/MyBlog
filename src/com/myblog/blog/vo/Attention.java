/**
 * GitHub address:
 * @Title: Attention.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/23 20:11 AM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

/**
 * @className Attention
 * @description 封装数据库Attention表数据
 * @author ZSZ
 * @data 2019/7/23 20:12 AM
 */
public class Attention {
    private int id;
    private int uid;
    private int aid;

    public Attention(){}

    public Attention(int uid,int aid){
        this.uid = uid;
        this.aid = aid;
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

    public int getAid() {
        return aid;
    }

    public void setAid(int bid) {
        this.aid = bid;
    }
}
