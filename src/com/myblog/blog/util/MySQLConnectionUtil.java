/**
 * GitHub address:
 * @Title: MySQLConnectionUtil.java
 * @Package com.myblog.blog.util
 * @Description: 工具包
 * @author: ZSZ
 * @date: 2019/7/23 20:43 PM
 * @version 1.0
 *
 */
package com.myblog.blog.util;


import com.myblog.blog.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @className MySQLConnectionUtil
 * @description util工具类方便数据库操作
 * @author：ZSZ
 * @date: 2019/7/23 20:43 PM
 */
public class MySQLConnectionUtil {

    /**
     * @description 获取ResultSet，并返回User对象
     * @param rs
     * @return User对象
     * @throws SQLException
     */
    public static User CreateUserByRs(ResultSet rs) throws SQLException {
        User user = null;
        if(rs.next()){
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            String sex = rs.getString(4);
            String telephone = rs.getString(5);
            String email = rs.getString(6);
            int role = rs.getInt(7);
            String image = rs.getString(8);
            int status = rs.getInt(9);
            user = new User(id,username,password,sex,telephone,email,role,image,status);
        }
        return user;
    }

    /**
     * @description 获取ResultSet，并返回Blog对象
     * @param rs
     * @return Blog对象
     * @throws SQLException
     */
    public static Blog CreateBlogByRs(ResultSet rs) throws SQLException {
        Blog blog = null;
        if(rs.next()){
            int id = rs.getInt(1);
            int uid = rs.getInt(2);
            String title = rs.getString(3);
            String author = rs.getString(4);
            Timestamp time = rs.getTimestamp(5);
            String context = rs.getString(6);
            int see = rs.getInt(7);
            int thumbup = rs.getInt(8);
            blog = new Blog(id,uid,title,author,time,context,see,thumbup);
        }
        return blog;
    }

    /**
     * @description 获取ResultSet，并返回Review对象
     * @param rs
     * @return Review对象
     * @throws SQLException
     */
    public static Review CreateReviewByRs(ResultSet rs) throws SQLException {
        Review review = null;
        if(rs.next()){
            int id = rs.getInt(1);
            int uid = rs.getInt(2);
            int bid = rs.getInt(3);
            String context = rs.getString(4);
            Timestamp time = rs.getTimestamp(5);
            review = new Review(id,uid,bid,context,time);
        }
        return review;
    }

    /**
     * @description 获取ResultSet，并返回User数组
     * @param rs
     * @return User数组
     * @throws SQLException
     */
    public static List<User> CreateUserListByRs(ResultSet rs) throws SQLException {
        List<User> userList = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            String sex = rs.getString(4);
            String telephone = rs.getString(5);
            String email = rs.getString(6);
            int role = rs.getInt(7);
            String image = rs.getString(8);
            int status = rs.getInt(9);
            User user = new User(id,username,password,sex,telephone,email,role,image,status);
            userList.add(user);
        }
        return userList;
    }

    /**
     * @description 获取ResultSet，并返回Blog数组
     * @param rs
     * @return Blog数组
     * @throws SQLException
     */
    public static List<Blog> CreateBlogListByRs(ResultSet rs) throws SQLException {
        List<Blog> blogList = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            int uid = rs.getInt(2);
            String title = rs.getString(3);
            String author = rs.getString(4);
            Timestamp time = rs.getTimestamp(5);
            String context = rs.getString(6);
            int see = rs.getInt(7);
            int thumbup = rs.getInt(8);
            Blog blog = new Blog(id,uid,title,author,time,context,see,thumbup);
            blogList.add(blog);
        }
        return blogList;
    }

    public static List<Review> CreateReviewListByRs(ResultSet rs) throws SQLException {
        List<Review> reviewList = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            int uid = rs.getInt(2);
            int bid = rs.getInt(3);
            String context = rs.getString(4);
            Timestamp time = rs.getTimestamp(5);
            Review review = new Review(id,uid,bid,context,time);
            reviewList.add(review);
        }
        return reviewList;
    }

    /**
     * @description 通过PreparedStatement给传入的User对象设置参数
     * @param ps
     * @param user
     * @throws SQLException
     */
    public static void setUserParameters(PreparedStatement ps, User user) throws SQLException {
        ps.setInt(1,user.getId());
        ps.setString(2,user.getUsername());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getSex());
        ps.setString(5,user.getTelephone());
        ps.setString(6,user.getEmail());
        ps.setInt(7,user.getRole());
        ps.setString(8,user.getImage());
        ps.setInt(9,user.getStatus());
    }

    /**
     * @description 通过PreparedStatement给传入的Blog对象设置参数
     * @param ps
     * @param blog
     * @throws SQLException
     */
    public static void setBlogParameters(PreparedStatement ps, Blog blog) throws SQLException {
        ps.setInt(1,blog.getUid());
        ps.setString(2,blog.getTitle());
        ps.setString(3,blog.getAuthor());
        ps.setTimestamp(4,new Timestamp(blog.getTime().getTime()));
        ps.setString(5,blog.getContext());
        ps.setInt(6,blog.getSee());
        ps.setInt(7,blog.getThumbup());
    }

    /**
     * @description 通过PreparedStatement给传入的Review对象设置参数
     * @param ps
     * @param review
     * @throws SQLException
     */
    public static void setReviewParameters(PreparedStatement ps, Review review) throws SQLException {
        ps.setInt(1,review.getUid());
        ps.setInt(2,review.getBid());
        ps.setString(3,review.getContext());
        ps.setTimestamp(4,new Timestamp(review.getTime().getTime()));
    }

    /**
     * @description 通过PreparedStatement给传入的ThumbUp对象设置参数
     * @param ps
     * @param thumbUp
     * @throws SQLException
     */
    public static void setThumbUpParameters(PreparedStatement ps, ThumbUp thumbUp) throws SQLException {
        ps.setInt(1,thumbUp.getUid());
        ps.setInt(2,thumbUp.getBid());
    }

    /**
     * @description 通过PreparedStatement给传入的Collection对象设置参数
     * @param ps
     * @param collection
     * @throws SQLException
     */
    public static void setCollectionParameters(PreparedStatement ps, Collection collection) throws SQLException {
        ps.setInt(1,collection.getUid());
        ps.setInt(2,collection.getBid());
    }

    /**
     * @description 通过PreparedStatement给传入的Attention对象设置参数
     * @param ps
     * @param attention
     * @throws SQLException
     */
    public static void setAttentionParameters(PreparedStatement ps, Attention attention) throws SQLException {
        ps.setInt(1,attention.getUid());
        ps.setInt(2,attention.getAid());
    }

    /**
     * @description 通过PreparedStatement给传入的BlogClassification对象设置参数
     * @param ps
     * @param blogClassification
     * @throws SQLException
     */
    public static void setBlogClassificationParameters(PreparedStatement ps, BlogClassification blogClassification) throws SQLException {
        ps.setInt(1,blogClassification.getUid());
        ps.setInt(2,blogClassification.getBid());
        ps.setString(3,blogClassification.getClassification());
    }

    /**
     * @description 通过PreparedStatement设置参数当前页数和查询到的记录数量
     * @param ps
     * @param currentPage
     * @param recode
     * @throws Exception
     */
    public static void setCurrentPageAndRecodeParameters(PreparedStatement ps,int currentPage,int recode) throws Exception{
        ps.setInt(1,(currentPage-1)*recode);
        ps.setInt(2,recode);
    }

    /**
     * @description 根据sql语句返回查询到的数量
     * @param conn
     * @param sql
     * @return
     * @throws Exception
     */
    public static int getNumber(Connection conn, String sql) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                num = rs.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return num;
    }

    /**
     * 关闭PreparedStatement和ResultSet对象
     * @param ps
     * @param rs
     * @throws SQLException
     */
    public static void CloseAll(PreparedStatement ps,ResultSet rs) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
    }

}
