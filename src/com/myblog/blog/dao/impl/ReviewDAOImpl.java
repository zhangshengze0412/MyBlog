/**
 * GitHub address:
 * @Title: ReviewDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/24 22:08 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.IReviewDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
import com.myblog.blog.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @className ReviewDAOImpl
 * @description 定义对Review表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/24 22:08 PM
 */
public class ReviewDAOImpl implements IReviewDAO {

    private Connection conn = null;
    private PreparedStatement ps =null;
    private ResultSet rs = null;

    public ReviewDAOImpl(Connection conn) throws Exception{
        this.conn = conn;
    }

    @Override
    public Review findReviewByRid(Review review) throws Exception {
        Review review1 = null;
        String sql = "SELECT * FROM review WHERE id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,review.getId());
            rs = ps.executeQuery();
            review1 = MySQLConnectionUtil.CreateReviewByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return review1;
    }

    @Override
    public List<Review> findReviewListByUid(User user) throws Exception {
        List<Review> reviewList = null;
        String sql = "SELECT * FROM review WHERE uid=? ORDER BY time DESC,id DESC";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            reviewList = MySQLConnectionUtil.CreateReviewListByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return reviewList;
    }

    @Override
    public List<Review> findReviewListByBid(Blog blog) throws Exception {
        List<Review> reviewList = null;
        String sql = "SELECT * FROM review WHERE bid=? ORDER BY time DESC,id DESC";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getId());
            rs = ps.executeQuery();
            reviewList = MySQLConnectionUtil.CreateReviewListByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return reviewList;
    }

    @Override
    public void addReview(Review review) throws Exception {
        String sql = "INSERT review (uid,bid,context,time) VALUES (?,?,?,?)";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setReviewParameters(ps,review);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
    }

    @Override
    public void removeReviewById(Review review) throws Exception {
        String sql = "DELETE FROM review WHERE id = ?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,review.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
    }

    @Override
    public List<Review> findReviewList(int currentPage, int recode) throws Exception {
        List<Review> reviewList = null;
        String sql = "SELECT * FROM review ORDER BY time DESC,id DESC LIMIT ?,?";
        try {
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setCurrentPageAndRecodeParameters(ps,currentPage,recode);
            rs = ps.executeQuery();
            reviewList = MySQLConnectionUtil.CreateReviewListByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return reviewList;
    }

    @Override
    public int findReviewNum() throws Exception {
        String sql = "SELECT COUNT(*) FROM review";
        return MySQLConnectionUtil.getNumber(conn,sql);
    }

}
