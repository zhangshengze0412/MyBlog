/**
 * GitHub address:
 * @Title: collection.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/25 10:38 AM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

/**
 * @className collection
 * @description 封装数据库收藏表数据
 * @author ZSZ
 * @data 2019/7/25 10:38 AM
 */
public class Collection {
    private int id;
    private int uid;
    private int bid;

    public Collection(){}

    public Collection(int uid, int bid){
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
