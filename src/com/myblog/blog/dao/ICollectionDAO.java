/**
 * GitHub address:
 * @Title: ICollectionDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/25 10:39 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.Collection;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className ICollectionDAO
 * @description 定义对Collection表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/25 10:39 PM
 */
public interface ICollectionDAO {


    /**
     * @description 通过用户uid和文章bid查询是否存在收藏
     * @param collection
     * @return boolean是否存在
     * @throws Exception
     */
    boolean findByUidAndBid(Collection collection) throws Exception;

    /**
     * @description 通过用户id查询该用户收藏的文章bid列表List<Integer>
     * @param user
     * @return 文章bid列表List<Integer>
     * @throws Exception
     */
    List<Integer> findCollectionListByUid(User user) throws Exception;

    /**
     * @description 添加收藏
     * @param collection
     * @return boolean是否成功
     * @throws Exception
     */
    boolean addCollection(Collection collection) throws Exception;

    /**
     * @description 移除收藏
     * @param collection
     * @return boolean是否成功
     * @throws Exception
     */
    boolean removeByUidAndBid(Collection collection) throws Exception;
    
}
