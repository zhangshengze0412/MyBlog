/**
 * GitHub address:
 * @Title: IReviewDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/24 22:02 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className IReviewDAO
 * @description 定义对Review表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/24 22:02 PM
 */
public interface IReviewDAO {

    /**
     * @description 通过rid查询Review对象
     * @param review
     * @return Review对象
     * @throws Exception
     */
    Review findReviewByRid(Review review) throws Exception;

    /**
     * @description 通过用户查询List<Review>对象
     * @param user
     * @return List<Review>对象
     * @throws Exception
     */
    List<Review> findReviewListByUid(User user) throws Exception;

    /**
     * @description 通过文章查询List<Review>对象
     * @param blog
     * @return List<Review>对象
     * @throws Exception
     */
    List<Review> findReviewListByBid(Blog blog) throws Exception;


    /**
     * @descripton 增加Review记录
     * @param review
     * @throws Exception
     */
    void addReview(Review review) throws Exception;

    /**
     * @description 通过Id删除该Review
     * @param review
     * @throws Exception
     */
    void removeReviewById(Review review) throws Exception;

    /**
     * @description 根据页数和一页记录数查询ReviewList
     * @return List<Review>对象
     * @throws Exception
     */
    List<Review> findReviewList(int currentPage, int recode) throws Exception;

    /**
     * @description 查询评论总数
     * @return int
     * @throws Exception
     */
    int findReviewNum() throws Exception;

}
