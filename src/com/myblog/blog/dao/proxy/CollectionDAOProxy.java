/**
 * GitHub address:
 * @Title: CollectionDAOProxy.java
 * @Package com.myblog.blog.dao.proxy
 * @Description: 数据库操作的代理操作
 * @author: ZSZ
 * @date: 2019/7/25 10:40 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.ICollectionDAO;
import com.myblog.blog.dao.impl.CollectionDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.Collection;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className CollectionDAOProxy
 * @description 对Collection表的数据库操作的代理操作
 *              调用了CollectionDAOImpl中的方法，减低耦合以实现ICollectionDAO中定义的方法
 *              并对之前抛出的异常统一进行处理
 * @author ZSZ
 * @date 2019/7/25 10:40 AM
 */
public class CollectionDAOProxy implements ICollectionDAO{

    private ICollectionDAO dao = null;
    private IDatabaseConnection dbc = null;

    public CollectionDAOProxy() throws Exception {
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new CollectionDAOImpl(dbc.getConnection());
    }

    @Override
    public boolean findByUidAndBid(Collection collection) throws Exception {
        boolean flag = false;
        try{
            flag = dao.findByUidAndBid(collection);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return flag;
    }

    @Override
    public List<Integer> findCollectionListByUid(User user) throws Exception {
        List<Integer> bidList = null;
        try{
            bidList = dao.findCollectionListByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return bidList;
    }

    @Override
    public boolean addCollection(Collection collection) throws Exception {
        boolean flag = false;
        try{
            flag = dao.addCollection(collection);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return flag;
    }

    @Override
    public boolean removeByUidAndBid(Collection collection) throws Exception {
        boolean flag = false;
        try{
            flag = dao.removeByUidAndBid(collection);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return flag;
    }
}
