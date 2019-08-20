/**
 * GitHub address:
 * @Title: AttentionDAOProxy.java
 * @Package com.myblog.blog.dao.proxy
 * @Description: 数据库操作的代理操作
 * @author: ZSZ
 * @date: 2019/7/25 10:04 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.IAttentionDAO;
import com.myblog.blog.dao.impl.AttentionDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className AttentionDAOProxy
 * @description 对Attention表的数据库操作的代理操作
 *              调用了AttentionDAOImpl中的方法，减低耦合以实现IAttentionDAO中定义的方法
 *              并对之前抛出的异常统一进行处理
 * @author ZSZ
 * @date 2019/7/25 10:04 AM
 */
public class AttentionDAOProxy implements IAttentionDAO{

    private IAttentionDAO dao = null;
    private IDatabaseConnection dbc = null;

    public AttentionDAOProxy() throws Exception {
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new AttentionDAOImpl(dbc.getConnection());
    }


    @Override
    public boolean findByUidAndAid(Attention attention) throws Exception {
        boolean flag = false;
        try{
            flag = dao.findByUidAndAid(attention);
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
    public List<Integer> findList(User user, String sql) throws Exception {
        return null;
    }

    @Override
    public List<Integer> findAttentionListByUid(User user) throws Exception {
        List<Integer> AidList = null;
        try{
            AidList = dao.findAttentionListByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return AidList;
    }

    @Override
    public List<Integer> findFansListByUid(User user) throws Exception {
        List<Integer> AidList = null;
        try{
            AidList = dao.findFansListByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return AidList;
    }

    @Override
    public boolean addAttention(Attention attention) throws Exception {
        boolean flag = false;
        try{
            flag = dao.addAttention(attention);
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
    public boolean removeByUidAndAid(Attention attention) throws Exception {
        boolean flag = false;
        try{
            flag = dao.removeByUidAndAid(attention);
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
