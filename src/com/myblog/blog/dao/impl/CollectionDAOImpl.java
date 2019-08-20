/**
 * GitHub address:
 * @Title: CollectionDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/25 10:39 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.ICollectionDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.Collection;
import com.myblog.blog.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className CollectionDAOImpl
 * @description 定义对Collection表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/24 10:39 AM
 */
public class CollectionDAOImpl implements ICollectionDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public CollectionDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean findByUidAndBid(Collection collection) throws Exception {
        boolean flag = false;
        String sql = "SELECT COUNT(*) FROM collection WHERE uid=? AND bid=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setCollectionParameters(ps,collection);
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
    public List<Integer> findCollectionListByUid(User user) throws Exception {
        List<Integer> bidList = null;
        String sql = "SELECT bid FROM collection WHERE uid=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            bidList = new ArrayList<>();
            while (rs.next()){
                 bidList.add(rs.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return bidList;
    }

    @Override
    public boolean addCollection(Collection collection) throws Exception {
        boolean flag = false;
        String sql = "INSERT collection (uid,bid) VALUES (?,?)";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setCollectionParameters(ps,collection);
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
    public boolean removeByUidAndBid(Collection collection) throws Exception{
        boolean flag = false;
        String sql = "DELETE FROM collection WHERE uid=? AND bid=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setCollectionParameters(ps,collection);
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
