/**
 * GitHub address:
 * @Title: BlogDAOImpl.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/24 20:46 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.impl;

import com.myblog.blog.dao.IBlogDAO;
import com.myblog.blog.util.MySQLConnectionUtil;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @className BlogDAOImpl
 * @description 定义对Blog表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/24 20:46 PM
 */
public class BlogDAOImpl implements IBlogDAO {

    private Connection conn = null;
    private PreparedStatement ps =null;
    private ResultSet rs = null;

    public BlogDAOImpl(Connection conn) throws Exception{
        this.conn = conn;
    }

    @Override
    public Blog findBlogById(Blog blog) throws Exception {
        Blog blog1 = null;
        String sql = "SELECT * FROM blog WHERE id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getId());
            rs = ps.executeQuery();
            blog1 = MySQLConnectionUtil.CreateBlogByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return blog1;
    }

    @Override
    public Blog findBlogByUidAndBid(Blog blog) throws Exception {
        Blog blog1 = null;
        String sql = "SELECT * FROM blog WHERE uid=? AND id =?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getUid());
            ps.setInt(2,blog.getId());
            rs = ps.executeQuery();
            blog1 = MySQLConnectionUtil.CreateBlogByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return blog1;
    }

    @Override
    public Blog findBlogByUidAndTitle(Blog blog) throws Exception {
        Blog blog1 = null;
        String sql = "SELECT * FROM blog WHERE uid=? AND title=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getUid());
            ps.setString(2,blog.getTitle());
            rs = ps.executeQuery();
            blog1 = MySQLConnectionUtil.CreateBlogByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return blog1;
    }

    @Override
    public Blog findBlogByTitle(Blog blog) throws Exception {
        Blog blog1 = null;
        String sql = "SELECT * FROM blog WHERE title=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,blog.getTitle());
            rs = ps.executeQuery();
            blog1 = MySQLConnectionUtil.CreateBlogByRs(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return blog1;
    }

    @Override
    public void addBlog(Blog blog) throws Exception {
        String sql = "INSERT blog (uid,title,author,time,context,see,thumbup) VALUES (?,?,?,?,?,?,?)";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setBlogParameters(ps,blog);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
    }

    @Override
    public void removeBlogById(Blog blog) throws Exception {
        String sql = "DELETE FROM blog WHERE id = ?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
    }

    @Override
    public Blog updateBlog(Blog blog) throws Exception {
        Blog newBlog = null;
        String sql = "UPDATE blog SET uid=?, title=?, author=?, time=?, context=?, see=?, thumbup=? WHERE id=?";
        try{
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setBlogParameters(ps,blog);
            ps.setInt(8,blog.getId());
            ps.execute();
            newBlog = blog;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return newBlog;
    }

    @Override
    public Blog updateBlogAuthor(Blog blog) throws Exception {
        Blog newBlog = null;
        String sql = "UPDATE blog SET author=? WHERE id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,blog.getAuthor());
            ps.setInt(2,blog.getId());
            ps.execute();
            newBlog = blog;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return newBlog;
    }

    @Override
    public List<Blog> findBlogList(int currentPage, int recode,String sql) throws Exception {
        List<Blog> BlogList = null;
        try {
            ps = conn.prepareStatement(sql);
            MySQLConnectionUtil.setCurrentPageAndRecodeParameters(ps,currentPage,recode);
            rs = ps.executeQuery();
            BlogList = MySQLConnectionUtil.CreateBlogListByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return BlogList;
    }
    
    @Override
    public List<Blog> findBlogListBySee(int currentPage, int recode) throws Exception {
        String sql = "SELECT * FROM blog ORDER BY see DESC,id DESC LIMIT ?,?";
        return findBlogList(currentPage,recode,sql);
    }

    @Override
    public List<Blog> findBlogListByTime(int currentPage, int recode) throws Exception {
        String sql = "SELECT * FROM blog ORDER BY time DESC,id DESC LIMIT ?,?";
        return findBlogList(currentPage,recode,sql);
    }

    @Override
    public List<Blog> findBlogListByKey(String key) throws Exception {
        List<Blog> BlogList = null;
        String sql = "SELECT * FROM blog WHERE title LIKE ? OR author LIKE ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+key+"%");
            ps.setString(2,"%"+key+"%");
            rs = ps.executeQuery();
            BlogList = MySQLConnectionUtil.CreateBlogListByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return BlogList;
    }

    @Override
    public List<Blog> findBlogListByUid(int currentPage, int recode, User user) throws Exception {
        List<Blog> BlogList = null;
        String sql = "SELECT * FROM blog WHERE uid=? ORDER BY time DESC,id DESC LIMIT ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setInt(2,(currentPage-1)*recode);
            ps.setInt(3,recode);
            rs = ps.executeQuery();
            BlogList = MySQLConnectionUtil.CreateBlogListByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return BlogList;
    }

    @Override
    public List<Blog> findBlogListByUid(User user) throws Exception {
        List<Blog> BlogList = null;
        String sql = "SELECT * FROM blog WHERE uid=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            BlogList = MySQLConnectionUtil.CreateBlogListByRs(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            MySQLConnectionUtil.CloseAll(ps,rs);
        }
        return BlogList;
    }

    @Override
    public int findBlogNum() throws Exception {
        String sql = "SELECT COUNT(*) FROM blog";
        return MySQLConnectionUtil.getNumber(conn,sql);
    }

    @Override
    public int findBlogNumByUid(User user) throws Exception {
        int num = 0;
        String sql = "SELECT COUNT(*) FROM blog WHERE uid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
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

}
