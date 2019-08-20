/**
 * GitHub address:
 * @Title: BlogClassificationDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/25 11:51 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.IBlogClassificationDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.BlogClassification;
import com.myblog.blog.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className BlogClassificationDAOImpl
 * @description 定义对Blog_Classification表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/25 11:51 AM
 */
public class BlogClassificationDAOImpl implements IBlogClassificationDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public BlogClassificationDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean findBlogClassification(BlogClassification blogClassification) throws Exception {
        boolean flag = false;
        String sql = "SELECT COUNT(*) FROM blog_classification WHERE uid=? AND bid=? AND classification=?";
        try {
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setBlogClassificationParameters(ps,blogClassification);
            rs = ps.executeQuery();
            if(rs.next()){
                if (rs.getInt(1)>0){
                    flag = true;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return flag;
    }

    @Override
    public List<String> findBlogClassificationListByUid(User user) throws Exception {
        List<String> classificationList = null;
        String sql = "SELECT classification FROM blog_classification WHERE uid=? GROUP BY classification";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            classificationList = new ArrayList<>();
            while(rs.next()){
                classificationList.add(rs.getString(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return classificationList;
    }

    @Override
    public List<String> findBlogClassificationByBid(BlogClassification blogClassification) throws Exception {
        List<String> classificationList = null;
        String sql = "SELECT classification FROM blog_classification WHERE bid=? AND uid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogClassification.getBid());
            ps.setInt(2,blogClassification.getUid());
            rs = ps.executeQuery();
            classificationList = new ArrayList<>();
            while(rs.next()){
                classificationList.add(rs.getString(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return classificationList;
    }

    @Override
    public List<Integer> findBlogByClassification(int currentPage,int record,BlogClassification blogClassification) throws Exception {
        List<Integer> classificationList = null;
        String sql = "SELECT bid FROM blog_classification WHERE uid=? AND classification=? ORDER BY id DESC LIMIT ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogClassification.getUid());
            ps.setString(2,blogClassification.getClassification());
            ps.setInt(3,(currentPage-1)*record);
            ps.setInt(4,record);
            rs = ps.executeQuery();
            classificationList = new ArrayList<>();
            while(rs.next()){
                classificationList.add(rs.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return classificationList;
    }

    @Override
    public int findBlogNumByClassification(BlogClassification blogClassification) throws Exception {
        int num = 0;
        String sql = "SELECT COUNT(bid) FROM blog_classification WHERE uid=? AND classification=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogClassification.getUid());
            ps.setString(2,blogClassification.getClassification());
            rs = ps.executeQuery();
            if (rs.next()){
                num = rs.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return num;
    }

    @Override
    public boolean addBlogClassification(BlogClassification blogClassification) throws Exception {
        boolean flag = false;
        String sql = "INSERT blog_classification (uid,bid,classification) VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setBlogClassificationParameters(ps,blogClassification);
            ps.execute();
            flag = true;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return flag;
    }

    @Override
    public boolean removeBlogClassification(BlogClassification blogClassification) throws Exception {
        boolean flag = false;
        String sql = "DELETE FROM blog_classification WHERE uid=? AND bid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogClassification.getUid());
            ps.setInt(2,blogClassification.getBid());
            ps.execute();
            flag = true;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return flag;
    }
}
