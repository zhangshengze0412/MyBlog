/**
 * GitHub address:
 * @Title: AttentionDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/25 8:36 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.IAttentionDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className AttentionDAOImpl
 * @description 定义对Attention表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/24 16:52 AM
 */
public class AttentionDAOImpl implements IAttentionDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public AttentionDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean findByUidAndAid(Attention attention) throws Exception {
        boolean flag = false;
        String sql = "SELECT COUNT(*) FROM attention WHERE uid=? AND aid=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setAttentionParameters(ps,attention);
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
    public List<Integer> findList(User user, String sql) throws Exception {
        List <Integer> AidList = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            AidList = new ArrayList<>();
            while(rs.next()){
                AidList.add(rs.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return AidList;
    }

    @Override
    public List<Integer> findAttentionListByUid(User user) throws Exception {
        String sql = "SELECT aid FROM attention WHERE uid=?";
        return findList(user,sql);
    }

    @Override
    public List<Integer> findFansListByUid(User user) throws Exception {
        String sql = "SELECT uid FROM attention WHERE aid=?";
        return findList(user,sql);
    }

    @Override
    public boolean addAttention(Attention attention) throws Exception {
        boolean flag = false;
        String sql = "INSERT attention (uid,aid) VALUES (?,?)";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setAttentionParameters(ps,attention);
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
    public boolean removeByUidAndAid(Attention attention) throws Exception{
        boolean flag = false;
        String sql = "DELETE FROM attention WHERE uid=? AND aid=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setAttentionParameters(ps,attention);
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
