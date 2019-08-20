/**
 * GitHub address:
 * @Title: ReviewDAOProxy.java
 * @Package com.myblog.blog.dao.proxy
 * @Description: 数据库操作的代理操作
 * @author: ZSZ
 * @date: 2019/7/24 23:01 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dao.proxy;

import com.myblog.blog.dao.IReviewDAO;
import com.myblog.blog.dao.impl.ReviewDAOImpl;
import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.factory.DataBaseFactory;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
import com.myblog.blog.vo.User;

import java.util.List;

/**
 * @className ReviewDAOProxy
 * @description 对Review表的数据库操作的代理操作
 *              调用了ReviewDAOImpl中的方法，减低耦合以实现IReviewDAO中定义的方法
 *              并对之前抛出的异常统一进行处理
 * @author ZSZ
 * @date 2019/7/24 23:01 PM
 */
public class ReviewDAOProxy implements IReviewDAO {

    private IReviewDAO dao = null;
    private IDatabaseConnection dbc = null;

    public ReviewDAOProxy() throws Exception {
        dbc = DataBaseFactory.getDataBaseConnection();
        dao = new ReviewDAOImpl(dbc.getConnection());
    }
    
    @Override
    public Review findReviewByRid(Review review) throws Exception {
        Review review1 = null;
        try{
            review1 = dao.findReviewByRid(review);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return review1;
    }

    @Override
    public List<Review> findReviewListByUid(User user) throws Exception {
        List<Review> reviewList = null;
        try{
            reviewList = dao.findReviewListByUid(user);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return reviewList;
    }

    @Override
    public List<Review> findReviewListByBid(Blog blog) throws Exception {
        List<Review> reviewList = null;
        try{
            reviewList = dao.findReviewListByBid(blog);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return reviewList;
    }

    @Override
    public void addReview(Review review) throws Exception {
        try{
            dao.addReview(review);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
    }

    @Override
    public void removeReviewById(Review review) throws Exception {
        try{
            dao.removeReviewById(review);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
    }

    @Override
    public List<Review> findReviewList(int currentPage, int recode) throws Exception {
        List<Review> reviewList = null;
        try{
            reviewList = dao.findReviewList(currentPage,recode);
        }catch (ClassCastException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.Close();
        }
        return reviewList;
    }

    @Override
    public int findReviewNum() throws Exception {
        int num = 0;
        try{
            num = dao.findReviewNum();
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
