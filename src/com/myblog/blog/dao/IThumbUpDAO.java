/**
 * GitHub address:
 * @Title: IThumbUpDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/25 8:11 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.ThumbUp;

/**
 * @className IThumbUpDAO
 * @description 定义对ThumbUp表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/25 8:11 PM
 */
public interface IThumbUpDAO {


    /**
     * @description 通过用户uid和文章bid查询是否存在点赞
     * @param thumbUp
     * @return boolean是否存在
     * @throws Exception
     */
    boolean findByUidAndBid(ThumbUp thumbUp) throws Exception;

    /**
     * @description 通过文章bid查询该文章点赞人数
     * @param blog
     * @return int点赞人数
     * @throws Exception
     */
    int findThumbUpNumByBid(Blog blog) throws Exception;

    /**
     * @description 添加点赞
     * @param thumbUp
     * @return boolean是否成功
     * @throws Exception
     */
    boolean addThumbUp(ThumbUp thumbUp) throws Exception;

    /**
     * @description 移除点赞
     * @param thumbUp
     * @return boolean是否成功
     * @throws Exception
     */
    boolean removeByUidAndBid(ThumbUp thumbUp) throws Exception;
    
}
