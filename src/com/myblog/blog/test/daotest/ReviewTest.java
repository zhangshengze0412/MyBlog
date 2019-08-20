/**
 * Github address:
 * @Title: ReviewTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/25 17:31 PM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.Review;
import com.myblog.blog.vo.User;

import java.util.Iterator;
import java.util.List;

/**
 * @className ReviewTest
 * @description 测试ReviewDAOProxy类
 * @author ZSZ
 * @date 2019/7/25 20:58 PM
 */
public class ReviewTest {

    public static void main(String[] args) {
        ReviewTest test = new ReviewTest();
//        Review review7 = new Review(2018211260,2,"2018211260评：666",new Date());
//        test.addReviewTest(review7);
//        test.removeReviewByIdTest(new Review(7));
//        Review review1 = new Review(2018211261,1,"2018211261评：博主NB",new Date());
//        Review review2 = new Review(2018211261,1,"2018211261评：666",new Date());
//        Review review3 = new Review(2018211261,2,"2018211261评：博主NB",new Date());
//        Review review4 = new Review(2018211261,2,"2018211261评：666",new Date());
//        Review review5 = new Review(2018211260,1,"2018211260评：博主NB",new Date());
//        Review review6 = new Review(2018211260,2,"2018211260评：666",new Date());
//        test.addReviewTest(review1);
//        test.addReviewTest(review2);
//        test.addReviewTest(review3);
//        test.addReviewTest(review4);
//        test.addReviewTest(review5);
//        test.addReviewTest(review6);
//        test.findReviewByRidTest(new Review(1));
//        test.findReviewListByUidTest(new User(2018211260));
//        test.findReviewListByUidTest(new User(2018211261));
//        test.findReviewListByBidTest(new Blog(1));
//        test.findReviewListByBidTest(new Blog(2));
//        test.findReviewListTest(1,5);
        test.findReviewNumTest();

    }

    /**
     * @description 测试findReviewByRid方法，通过评论id查询评论
     * @param review
     */
    private void findReviewByRidTest(Review review){
        Review rw = null;
        try {
            rw = DAOFactory.getReviewDAOInstance().findReviewByRid(review);
            if (rw != null){
                System.out.println("findReviewByRid方法测试成功！！！");
                System.out.println("id:"+rw.getId()+"  uid:"+rw.getUid()+"  bid:"+rw.getBid()+"  context:"+rw.getContext()+"  time:"+rw.getTime()+"\n");
            }else{
                System.out.println("findReviewByRid方法测试失败！！！\n");
            }
        }catch (Exception e){
            System.out.println("findReviewByRid方法测试失败！！！\n");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findReviewListByUid方法，通过用户查询该用户所有的评论
     * @param user
     */
    private void findReviewListByUidTest(User user) {
        List<Review> reviewList = null;
        try {
            reviewList = DAOFactory.getReviewDAOInstance().findReviewListByUid(user);
            if (reviewList != null) {
                System.out.println("findReviewListByUid方法测试成功！！！共有"+reviewList.size()+"条评论");
                Iterator<Review> it = reviewList.iterator();
                while (it.hasNext()) {
                    Review rw = it.next();
                    System.out.println("id:" + rw.getId() + "  uid:" + rw.getUid() + "  bid:" + rw.getBid() + "  context:" + rw.getContext() + "  time:" + rw.getTime());
                }
                System.out.println();
            } else {
                System.out.println("findReviewListByUid方法测试失败！！！\n");
            }
        } catch (Exception e) {
            System.out.println("findReviewListByUid方法测试失败！！！\n");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findReviewListByBid方法，通过博客查询该博客所有的评论
     * @param blog
     */
    private void findReviewListByBidTest(Blog blog){
        List<Review> reviewList = null;
        try {
            reviewList = DAOFactory.getReviewDAOInstance().findReviewListByBid(blog);
            if (reviewList != null){
                System.out.println("findReviewListByBid方法测试成功！！！共有"+reviewList.size()+"条评论");
                Iterator<Review> it = reviewList.iterator();
                while (it.hasNext()){
                    Review rw = it.next();
                    System.out.println("id:"+rw.getId()+"  uid:"+rw.getUid()+"  bid:"+rw.getBid()+"  context:"+rw.getContext()+"  time:"+rw.getTime());
                }
                System.out.println();
            }else{
                System.out.println("findReviewListByBid方法测试失败！！！\n");
            }
        }catch (Exception e){
            System.out.println("findReviewListByBid方法测试失败！！！\n");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试addReview方法，添加pl
     * @param review
     */
    private void addReviewTest(Review review){
        try {
            DAOFactory.getReviewDAOInstance().addReview(review);
            System.out.println("addReview方法测试成功！！！");
        } catch (Exception e){
            System.out.println("addReview方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试removeReviewById方法，通过id删除评论
     * @param review
     */
    private void removeReviewByIdTest(Review review){
        try {
            DAOFactory.getReviewDAOInstance().removeReviewById(review);
            System.out.println("removeReviewById方法测试成功！！！");
        } catch (Exception e){
            System.out.println("removeReviewById方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findReviewList方法，查询所有评论（按时间降序）
     * @param currentPage
     * @param recode
     */
    private void findReviewListTest(int currentPage,int recode){
        List<Review> reviewList = null;
        try {
            reviewList = DAOFactory.getReviewDAOInstance().findReviewList(currentPage,recode);
            if (reviewList != null){
                System.out.println("findReviewList方法测试成功！！！");
                Iterator<Review> it = reviewList.iterator();
                while (it.hasNext()){
                    Review rw = it.next();
                    System.out.println("id:"+rw.getId()+"  uid:"+rw.getUid()+"  bid:"+rw.getBid()+"  context:"+rw.getContext()+"  time:"+rw.getTime());
                }
                System.out.println();
            }else{
                System.out.println("findReviewList方法测试失败！！！\n");
            }
        }catch (Exception e){
            System.out.println("findReviewList方法测试失败！！！\n");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findReviewNum方法，返回评论总数
     */
    private void findReviewNumTest(){
        int num = 0;
        try {
            num = DAOFactory.getReviewDAOInstance().findReviewNum();
            if (num != 0){
                System.out.println("findReviewNum方法测试成功！！！"+ "一共存在："+num+"个评论！");
            } else {
                System.out.println("findReviewNum方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
