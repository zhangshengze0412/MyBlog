/**
 * GitHub address:
 * @Title: BlogDAOProxy.java
 * @Package com.myblog.blog.dao.proxy
 * @Description: 数据库操作的代理操作
 * @author: ZSZ
 * @date: 2019/7/24 21:01 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.IBlogDAO;
import com.myblog.blog.dao.impl.BlogDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className BlogDAOProxy
 * @description 对Blog表的数据库操作的代理操作
 *              调用了BlogDAOImpl中的方法，减低耦合以实现IBlogDAO中定义的方法
 *              并对之前抛出的异常统一进行处理
 * @author ZSZ
 * @date 2019/7/24 21:01 PM
 */
public class BlogDAOProxy implements IBlogDAO {

    private IBlogDAO dao = null;
    private IDatabaseConnection dbc = null;

    public BlogDAOProxy() throws Exception {
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new BlogDAOImpl(dbc.getConnection());
    }

    @Override
    public Blog findBlogById(Blog blog) throws Exception {
        Blog blog1 = null;
        try{
            blog1 = dao.findBlogById(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blog1;
    }

    @Override
    public Blog findBlogByUidAndBid(Blog blog) throws Exception {
        Blog blog1 = null;
        try{
            blog1 = dao.findBlogByUidAndBid(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blog1;
    }

    @Override
    public Blog findBlogByUidAndTitle(Blog blog) throws Exception {
        Blog blog1 = null;
        try{
            blog1 = dao.findBlogByUidAndTitle(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blog1;
    }

    @Override
    public Blog findBlogByTitle(Blog blog) throws Exception {
        Blog blog1 = null;
        try{
            blog1 = dao.findBlogByTitle(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blog1;
    }

    @Override
    public void addBlog(Blog blog) throws Exception {
        try{
            dao.addBlog(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
    }

    @Override
    public void removeBlogById(Blog blog) throws Exception {
        try{
            dao.removeBlogById(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
    }

    @Override
    public Blog updateBlog(Blog blog) throws Exception {
        Blog blog1 = null;
        try{
            blog1 = dao.updateBlog(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blog1;
    }

    @Override
    public Blog updateBlogAuthor(Blog blog) throws Exception {
        Blog blog1 = null;
        try{
            blog1 = dao.updateBlogAuthor(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blog1;
    }

    @Override
    public List<Blog> findBlogList(int currentPage,int recode,String sql) throws Exception {
        return null;
    }

    public List<Blog> findBlogListBySee(int currentPage,int recode) throws Exception {
        List<Blog> blogList = null;
        try{
            blogList = dao.findBlogListBySee(currentPage,recode);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blogList;
    }

    public List<Blog> findBlogListByTime(int currentPage,int recode) throws Exception {
        List<Blog> blogList = null;
        try{
            blogList = dao.findBlogListByTime(currentPage,recode);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blogList;
    }

    @Override
    public List<Blog> findBlogListByKey(String key) throws Exception {
        List<Blog> blogList = null;
        try{
            blogList = dao.findBlogListByKey(key);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blogList;
    }

    @Override
    public List<Blog> findBlogListByUid(int currentPage, int recode, User user) throws Exception {
        List<Blog> blogList = null;
        try{
            blogList = dao.findBlogListByUid(currentPage,recode,user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blogList;
    }

    @Override
    public List<Blog> findBlogListByUid(User user) throws Exception {
        List<Blog> blogList = null;
        try{
            blogList = dao.findBlogListByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return blogList;
    }

    @Override
    public int findBlogNum() throws Exception {
        int num = 0;
        try{
            num = dao.findBlogNum();
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return num;
    }

    @Override
    public int findBlogNumByUid(User user) throws Exception {
        int num = 0;
        try{
            num = dao.findBlogNumByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return num;
    }

}
