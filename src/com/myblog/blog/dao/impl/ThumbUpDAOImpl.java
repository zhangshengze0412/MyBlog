/**
 * GitHub address:
 * @Title: ThumbUpDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/25 8:36 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.IThumbUpDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.ThumbUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @className ThumbUpDAOImpl
 * @description 定义对ThumbUp表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/25 8:36 AM
 */
public class ThumbUpDAOImpl implements IThumbUpDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ThumbUpDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean findByUidAndBid(ThumbUp thumbUp) throws Exception {
        boolean flag = false;
        String sql = "SELECT COUNT(*) FROM thumbup WHERE uid=? AND bid=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setThumbUpParameters(ps,thumbUp);
            rs = ps.executeQuery();
            if (rs.next()){
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
    public int findThumbUpNumByBid(Blog blog) throws Exception {
        int num = 0;
        String sql = "SELECT COUNT(*) FROM thumbup WHERE bid=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getId());
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
    public boolean addThumbUp(ThumbUp thumbUp) throws Exception {
        boolean flag = false;
        String sql = "INSERT thumbup (uid,bid) VALUES (?,?)";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setThumbUpParameters(ps,thumbUp);
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
    public boolean removeByUidAndBid(ThumbUp thumbUp) throws Exception{
        boolean flag = false;
        String sql = "DELETE FROM thumbup WHERE uid=? AND bid=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setThumbUpParameters(ps,thumbUp);
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
