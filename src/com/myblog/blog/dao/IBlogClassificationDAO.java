/**
 * GitHub address:
 * @Title: IBlogClassificationDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/25 11:33 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.BlogClassification;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className IBlogClassificationDAO
 * @description 定义对blog_classification表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/25 11:33 AM
 */
public interface IBlogClassificationDAO {

    /**
     * @decription 通过用户、文章和类别，查询是否匹配
     * @param blogClassification
     * @return boolean 匹配成功标志
     * @throws Exception
     */
    boolean findBlogClassification(BlogClassification blogClassification) throws Exception;

    /**
     * @decription 查询该用户所有已存在的类别
     * @return List<String>类别列表
     * @throws Exception
     */
    List<String> findBlogClassificationListByUid(User user) throws Exception;

    /**
     * @decription 查询该文章所属的类别
     * @param blogClassification
     * @return List<String>类别列表
     * @throws Exception
     */
    List<String> findBlogClassificationByBid(BlogClassification blogClassification) throws Exception;

    /**
     * @decription 查询该用户类别下的文章id列表(分页显示)
     * @param blogClassification
     * @return List<Integer>文章id列表
     * @throws Exception
     */
    List<Integer> findBlogByClassification(int currentPage,int record,BlogClassification blogClassification) throws Exception;

    /**
     * @decription 查询该用户该类别下的文章数量
     * @param blogClassification
     * @return int
     * @throws Exception
     */
    int findBlogNumByClassification(BlogClassification blogClassification) throws Exception;

    /**
     * @decription 通过用户、文章和类别，添加该记录
     * @param blogClassification
     * @return boolean 添加成功标志
     * @throws Exception
     */
    boolean addBlogClassification(BlogClassification blogClassification) throws Exception;

    /**
     * @decription 通过用户id、文章id，删除该记录
     * @param blogClassification
     * @return boolean 删除成功标志
     * @throws Exception
     */
    boolean removeBlogClassification(BlogClassification blogClassification) throws Exception;
}
