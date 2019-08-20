/**
 * GitHub address:
 * @Title: BlogClassificationDAOProxy.java
 * @Package com.myblog.blog.dao.impl
 * @Description: 数据库操作的具体实现
 * @author: ZSZ
 * @date: 2019/7/25 12:37 AM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.IBlogClassificationDAO;
import com.myblog.blog.dao.impl.BlogClassificationDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.BlogClassification;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className BlogClassificationDAOProxy
 * @description 定义对blog_classification表的数据库操作的具体实现
 * @author ZSZ
 * @date 2019/7/25 12:47 AM
 */
public class BlogClassificationDAOProxy implements IBlogClassificationDAO {

    private IBlogClassificationDAO dao = null;
    private IDatabaseConnection dbc = null;

    public BlogClassificationDAOProxy() throws Exception{
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new BlogClassificationDAOImpl(dbc.getConnection());
    }

    @Override
    public boolean findBlogClassification(BlogClassification blogClassification) throws Exception {
        boolean flag = false;
        try{
            flag = dao.findBlogClassification(blogClassification);
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
    public List<String> findBlogClassificationListByUid(User user) throws Exception {
        List<String> classificationList = null;
        try{
            classificationList = dao.findBlogClassificationListByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return classificationList;
    }

    @Override
    public List<String> findBlogClassificationByBid(BlogClassification blogClassification) throws Exception {
        List<String> classificationList = null;
        try{
            classificationList = dao.findBlogClassificationByBid(blogClassification);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return classificationList;
    }

    @Override
    public int findBlogNumByClassification(BlogClassification blogClassification) throws Exception {
        int num = 0;
        try{
            num = dao.findBlogNumByClassification(blogClassification);
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
    public List<Integer> findBlogByClassification(int currentPage,int record,BlogClassification blogClassification) throws Exception {
        List<Integer> bidList = null;
        try{
            bidList = dao.findBlogByClassification(currentPage,record,blogClassification);
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
    public boolean addBlogClassification(BlogClassification blogClassification) throws Exception {
        boolean flag = false;
        try{
            flag = dao.addBlogClassification(blogClassification);
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
    public boolean removeBlogClassification(BlogClassification blogClassification) throws Exception {
        boolean flag = false;
        try{
            flag = dao.removeBlogClassification(blogClassification);
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
