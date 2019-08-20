/**
 * GitHub address:
 * @Title: IUserDAO.java
 * @Package com.myblog.blog.dao
 * @Description: 数据库操作
 * @author: ZSZ
 * @date: 2019/7/24 16:27 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao;

import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className IUserDAO
 * @description 定义对User表的数据库操作接口
 * @author ZSZ
 * @date 2019/7/24 16:31 PM
 */
public interface IUserDAO {

    /**
     * @description 通过Id查询User对象
     * @param user
     * @return User对象
     * @throws Exception
     */
    User findUserById(User user) throws Exception;

    /**
     * @description 通过name查询User对象
     * @param user
     * @return User对象
     * @throws Exception
     */
    User findUserByName(User user) throws Exception;

    /**
     * @descripton 增加User记录
     * @param user
     * @throws Exception
     */
    void addUser(User user) throws Exception;

    /**
     * @description 通过Id删除该User
     * @param user
     * @throws Exception
     */
    void removeUserById(User user) throws Exception;

    /**
     * @description 更新User信息
     * @param user
     * @return User对象
     * @throws Exception
     */
    User updateUser(User user) throws Exception;

    /**
     * @description 验证User密码和id是否正确
     * @param user
     * @return User对象
     * @throws Exception
     */
    User checkLogin(User user) throws Exception;

    /**
     * @description 根据页数和一页记录数查询UserList
     * @return List<User>对象
     * @throws Exception
     */
    List<User> findUser(int currentPage,int recode) throws Exception;

    /**
     * @description 查询所有用户数量
     * @return int number
     * @throws Exception
     */
    int findUserNum() throws Exception;
}
