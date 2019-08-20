/**
 * GitHub address:
 * @Title: ThumbUpDAOProxy.java
 * @Package com.myblog.blog.dao.proxy
 * @Description: 数据库操作的代理操作
 * @author: ZSZ
 * @date: 2019/7/25 8:56 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.IThumbUpDAO;
import com.myblog.blog.dao.impl.ThumbUpDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.ThumbUp;

/**
 * @className ThumbUpDAOProxy
 * @description 对ThumbUp表的数据库操作的代理操作
 *              调用了ThumbUpDAOImpl中的方法，减低耦合以实现IThumbUpDAO中定义的方法
 *              并对之前抛出的异常统一进行处理
 * @author ZSZ
 * @date 2019/7/25 8:56 AM
 */
public class ThumbUpDAOProxy implements IThumbUpDAO{

    private IThumbUpDAO dao = null;
    private IDatabaseConnection dbc = null;

    public ThumbUpDAOProxy() throws Exception {
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new ThumbUpDAOImpl(dbc.getConnection());
    }

    @Override
    public boolean findByUidAndBid(ThumbUp thumbUp) throws Exception {
        boolean flag = false;
        try{
            flag = dao.findByUidAndBid(thumbUp);
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
    public int findThumbUpNumByBid(Blog blog) throws Exception {
        int num = 0;
        try{
            num = dao.findThumbUpNumByBid(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return num;
    }

    @Override
    public boolean addThumbUp(ThumbUp thumbUp) throws Exception {
        boolean flag = false;
        try{
            flag = dao.addThumbUp(thumbUp);
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
    public boolean removeByUidAndBid(ThumbUp thumbUp) throws Exception {
        boolean flag = false;
        try{
            flag = dao.removeByUidAndBid(thumbUp);
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
