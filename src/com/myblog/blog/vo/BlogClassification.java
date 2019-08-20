/**
 * GitHub address:
 * @Title: BlogClassificationTest.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/25 11:24 AM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

/**
 * @className BlogClassificationTest
 * @description 封装文章分类对象数据
 * @author ZSZ
 * @data 2019/7/25 11;28 AM
 *
 */
public class BlogClassification {
    private int id;
    private int uid;
    private int bid;
    private String classification;

    public BlogClassification(){}

    public BlogClassification(int uid,int bid){
        this.uid = uid;
        this.bid = bid;
    }

    public BlogClassification(String classification){
        this.classification = classification;
    }

    public BlogClassification(int uid,String classification){
        this.uid = uid;
        this.classification = classification;
    }

    public BlogClassification(int uid,int bid,String classification){
        this.uid = uid;
        this.bid = bid;
        this.classification = classification;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
