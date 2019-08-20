/**
 * GitHub address:
 * @Title: UserDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/24 16:27 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.IUserDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @className UserDAOImpl
 * @description 定义对User表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/24 16:52 PM
 */
public class UserDAOImpl implements IUserDAO {

    private Connection conn = null;
    private PreparedStatement ps =null;
    private ResultSet rs = null;

    public UserDAOImpl(Connection conn) throws Exception{
        this.conn = conn;
    }

    @Override
    public User findUserById(User user) throws Exception {
        User user1 = null;
        String sql = "SELECT * FROM user WHERE id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            user1 = MySQLConnectionUtil.CreateUserByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return user1;
    }

    @Override
    public User findUserByName(User user) throws Exception {
        User user1 = null;
        String sql = "SELECT * FROM user WHERE username=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            rs = ps.executeQuery();
            user1 = MySQLConnectionUtil.CreateUserByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return user1;
    }

    @Override
    public void addUser(User user) throws Exception {
        String sql = "INSERT user (id,username,password,sex,telephone,email,role,image,status) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setUserParameters(ps,user);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
    }

    @Override
    public void removeUserById(User user) throws Exception {
        String sql = "DELETE FROM user WHERE id = ?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
    }

    @Override
    public User updateUser(User user) throws Exception {
        User newUser = null;
        String sql = "UPDATE user SET id=?, username=?, password=?, sex=?, telephone=?, email=?, role=?, image=?, status=? WHERE id=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setUserParameters(ps,user);
            ps.setInt(10,user.getId());
            ps.execute();
            newUser = user;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return newUser;
    }

    @Override
    public User checkLogin(User user) throws Exception {
        User user1 = null;
        String sql="SELECT * FROM user WHERE id=? AND password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            user1 = MySQLConnectionUtil.CreateUserByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return user1;
    }

    @Override
    public List<User> findUser(int currentPage, int recode) throws Exception {
        List<User> userList = null;
        String sql = "SELECT * FROM user LIMIT ?,?";
        try {
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setCurrentPageAndRecodeParameters(ps,currentPage,recode);
            rs = ps.executeQuery();
            userList = MySQLConnectionUtil.CreateUserListByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return userList;
    }

    @Override
    public int findUserNum() throws Exception {
        String sql = "SELECT COUNT(*) FROM user ";
        return MySQLConnectionUtil.getNumber(conn,sql);
    }
}
