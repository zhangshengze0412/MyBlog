/**
 * Github address:
 * @Title: ThumbUpTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/25 22:05 PM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.ThumbUp;

/**
 * @className: ThumbUpTest
 * @description: 测试ThumbUpDAOProxy中的方法
 * @author: ZSZ
 * @date: 2019/7/25 22:05
 */
public class ThumbUpTest {

    public static void main(String[] args) {
//        ThumbUpTest test = new ThumbUpTest();
//        ThumbUp thumbUp1 = new ThumbUp(2018211261,1);
//        ThumbUp thumbUp2 = new ThumbUp(2018211260,1);
//        test.addThumbUpTest(thumbUp1);
//        test.addThumbUpTest(thumbUp2);
//        test.findByUidAndBidTest(thumbUp1);
//        test.findThumbUpNumByBidTest(new Blog(1));
//        test.removeByUidAndBidTest(thumbUp1);
//        test.removeByUidAndBidTest(thumbUp2);
    }

    /**
     * @description 测试findByUidAndBid方法，通过用户id和博客id查询
     * @param thumbUp
     */
    private void findByUidAndBidTest(ThumbUp thumbUp){
        try {
            if (DAOFactory.getThumbUpDAOInstance().findByUidAndBid(thumbUp)){
                System.out.println("findByUidAndBid方法测试成功！！！");
                System.out.println("用户"+thumbUp.getUid()+"给博客"+thumbUp.getBid()+"点赞！\n");
            }else {
                System.out.println("findByUidAndBid方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findThumbUpNumByBid方法，通过博客id查询该博客获赞数量
     * @param blog
     */
    private void findThumbUpNumByBidTest(Blog blog){
        int num = 0;
        try {
            num = DAOFactory.getThumbUpDAOInstance().findThumbUpNumByBid(blog);
            if (num != 0){
                System.out.println("findThumbUpNumByBid方法测试成功！！！");
                System.out.println("该博客获得"+num+"个赞！");
            }else {
                System.out.println("findThumbUpNumByBid方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试addThumbUp方法，通过用户id和博客id增加点赞
     * @param thumbUp
     */
    private void addThumbUpTest(ThumbUp thumbUp){
        try {
            if (DAOFactory.getThumbUpDAOInstance().addThumbUp(thumbUp)){
                System.out.println("addThumbUp方法测试成功！！！");
                System.out.println("用户"+thumbUp.getUid()+"给博客"+thumbUp.getBid()+"增加点赞！\n");
            }else {
                System.out.println("addThumbUp方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试removeByUidAndBid方法，通过用户id和博客id取消点赞
     * @param thumbUp
     */
    private void removeByUidAndBidTest(ThumbUp thumbUp){
        try {
            if (DAOFactory.getThumbUpDAOInstance().removeByUidAndBid(thumbUp)){
                System.out.println("removeByUidAndBid方法测试成功！！！");
                System.out.println("用户"+thumbUp.getUid()+"给博客"+thumbUp.getBid()+"取消点赞！\n");
            }else {
                System.out.println("removeByUidAndBid方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
