/**
 * GitHub address:
 * @Title: IAttentionDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/25 9:17 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className IAttentionDAO
 * @description 定义对Attention表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/25 9:17 PM
 */
public interface IAttentionDAO {

    /**
     * @description 通过用户uid和被关注用户aid查询是否存在点赞
     * @param attention
     * @return boolean是否存在
     * @throws Exception
     */
    boolean findByUidAndAid(Attention attention) throws Exception;

    /**
     * @description 查询关注列表
     * @param sql
     * @param user
     * @return List<Integer>用户id列表
     * @throws Exception
     */
    List<Integer> findList(User user,String sql) throws Exception;

    /**
     * @description 通过用户uid查询被关注的用户id列表
     * @param user
     * @return List<Integer>用户id列表
     * @throws Exception
     */
    List<Integer> findAttentionListByUid(User user) throws Exception;

    /**
     * @description 通过被关注的用户id查询该用户的粉丝列表
     * @param user
     * @return List<Integer>粉丝id列表
     * @throws Exception
     */
    List<Integer> findFansListByUid(User user) throws Exception;

    /**
     * @description 添加关注
     * @param attention
     * @return boolean是否成功
     * @throws Exception
     */
    boolean addAttention(Attention attention) throws Exception;

    /**
     * @description 移除关注
     * @param attention
     * @return boolean是否成功
     * @throws Exception
     */
    boolean removeByUidAndAid(Attention attention) throws Exception;
}
