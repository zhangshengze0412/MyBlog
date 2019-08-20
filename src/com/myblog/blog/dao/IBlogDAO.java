/**
 * GitHub address:
 * @Title: IBlogDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/24 20:35 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className IBlogDAO
 * @description 定义对Blog表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/24 20:35 PM
 */
public interface IBlogDAO {

    /**
     * @description 通过Id查询Blog对象
     * @param blog
     * @return Blog对象
     * @throws Exception
     */
    Blog findBlogById(Blog blog) throws Exception;

    /**
     * @description 通过用户Id和博客id查询Blog对象
     * @param blog
     * @return Blog对象
     * @throws Exception
     */
    Blog findBlogByUidAndBid(Blog blog) throws Exception;

    /**
     * @description 通过用户Id和博客名称查询Blog对象
     * @param blog
     * @return Blog对象
     * @throws Exception
     */
    Blog findBlogByUidAndTitle(Blog blog) throws Exception;

    /**
     * @description 通过title查询Blog对象
     * @param blog
     * @return Blog对象
     * @throws Exception
     */
    Blog findBlogByTitle(Blog blog) throws Exception;

    /**
     * @descripton 增加Blog记录
     * @param blog
     * @throws Exception
     */
    void addBlog(Blog blog) throws Exception;

    /**
     * @description 通过Id删除该Blog
     * @param blog
     * @throws Exception
     */
    void removeBlogById(Blog blog) throws Exception;

    /**
     * @description 更新Blog信息
     * @param blog
     * @return Blog对象
     * @throws Exception
     */
    Blog updateBlog(Blog blog) throws Exception;

    /**
     * @description 更新Blog的作者信息
     * @param blog
     * @return Blog对象
     * @throws Exception
     */
    Blog updateBlogAuthor(Blog blog) throws Exception;

    /**
     * @description 根据SQL、页数和一页记录数查询BlogList
     * @param currentPage
     * @param recode
     * @param sql
     * @return List<Blog>对象
     * @throws Exception
     */
    List<Blog> findBlogList(int currentPage,int recode,String sql) throws Exception;

    /**
     * @description 根据页数和一页记录数查询BlogList（按浏览数降序）
     * @param currentPage
     * @param recode
     * @return List<Blog>对象
     * @throws Exception
     */
    List<Blog> findBlogListBySee(int currentPage,int recode) throws Exception;

    /**
     * @description 根据页数和一页记录数查询BlogList（按时间降序）
     * @param currentPage
     * @param recode
     * @return List<Blog>对象
     * @throws Exception
     */
    List<Blog> findBlogListByTime(int currentPage,int recode) throws Exception;

    /**
     * @description 通过关键字查询Blog
     * @param key
     * @return List<Blog>对象
     * @throws Exception
     */
    List<Blog> findBlogListByKey(String key) throws Exception;

    /**
     * @description 根据用户、页数和一页记录数查询BlogList
     * @param currentPage
     * @param recode
     * @param user
     * @return List<Blog>对象
     * @throws Exception
     */
    List<Blog> findBlogListByUid(int currentPage, int recode, User user) throws Exception;

    /**
     * @description 根据用户查询BlogList
     * @param user
     * @return List<Blog>对象
     * @throws Exception
     */
    List<Blog> findBlogListByUid(User user) throws Exception;

    /**
     * @description 查询博客总数
     * @return int
     * @throws Exception
     */
    int findBlogNum() throws Exception;

    /**
     * @description 查询该用户写的博客总数
     * @param user
     * @return int
     * @throws Exception
     */
    int findBlogNumByUid(User user) throws Exception;
}
