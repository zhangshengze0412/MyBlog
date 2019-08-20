/**
 * GitHub address:
 * @Title: UserDAOProxy.java
 * @Package com.myblog.blog.dao.proxy
 * @Description: 数据库操作的代理操作
 * @author: ZSZ
 * @date: 2019/7/24 17:30 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.IUserDAO;

import com.myblog.blog.dao.impl.UserDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className UserDAOProxy
 * @description 对User表的数据库操作的代理操作
 *              调用了UserDAOImpl中的方法，减低耦合以实现IUserDAO中定义的方法
 *              并对之前抛出的异常统一进行处理
 * @author ZSZ
 * @date 2019/7/24 17:31 PM
 */
public class UserDAOProxy implements IUserDAO {

    private IUserDAO dao = null;
    private IDatabaseConnection dbc = null;

    public UserDAOProxy() throws Exception {
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new UserDAOImpl(dbc.getConnection());
    }

    @Override
    public User findUserById(User user) throws Exception {
        User user1 = null;
        try{
            user1 = dao.findUserById(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return user1;
    }

    @Override
    public User findUserByName(User user) throws Exception {
        User user1 = null;
        try{
            user1 = dao.findUserByName(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return user1;
    }

    @Override
    public void addUser(User user) throws Exception {
        try{
            dao.addUser(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
    }

    @Override
    public void removeUserById(User user) throws Exception {
        try{
            dao.removeUserById(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
    }

    @Override
    public User updateUser(User user) throws Exception {
        User user1 = null;
        try{
            user1 = dao.updateUser(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return user1;
    }

    @Override
    public User checkLogin(User user) throws Exception {
        User user1 = null;
        try{
            user1 = dao.checkLogin(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return user1;
    }

    @Override
    public List<User> findUser(int currentPage, int recode) throws Exception {
        List<User> userList = null;
        try{
            userList = dao.findUser(currentPage,recode);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return userList;
    }

    @Override
    public int findUserNum() throws Exception {
        int num = 0;
        try{
            num = dao.findUserNum();
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
