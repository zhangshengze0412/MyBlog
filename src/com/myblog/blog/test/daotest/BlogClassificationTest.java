/**
 * Github address:
 * @Title: BlogClassificationTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/26 8:28 AM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.BlogClassification;
import com.myblog.blog.vo.User;

import java.util.Iterator;
import java.util.List;

/**
 * @className: BlogClassificationTest
 * @description: 测试BlogClassificationDAOProxy类
 * @author: ZSZ
 * @date: 2019/7/26 8:28 AM
 */
public class BlogClassificationTest {

    public static void main(String[] args) {
        BlogClassificationTest test = new BlogClassificationTest();
//        BlogClassification classification1 = new BlogClassification(1,"数据科学");
//        BlogClassification classification2 = new BlogClassification(1,"NumPy");
//        BlogClassification classification3 = new BlogClassification(2,"数据科学");
//        BlogClassification classification4 = new BlogClassification(2,"NumPy");
//        BlogClassification classification5 = new BlogClassification(3,"IO");
//        BlogClassification classification6 = new BlogClassification(13,1,"Java");
//        test.addBlogClassificationTest(classification1);
//        test.addBlogClassificationTest(classification2);
//        test.addBlogClassificationTest(classification3);
//        test.addBlogClassificationTest(classification4);
//        test.addBlogClassificationTest(classification5);
//        test.addBlogClassificationTest(classification6);
//        test.findBlogClassificationTest(classification6);
//        test.findBlogByClassificationTest(1,2,new BlogClassification(2018211261,"数据科学"));
//        test.findBlogClassificationByBidTest(new BlogClassification(2018211261,26));
//        test.findBlogClassificationListByUidTest(new User(2018211261));
//        test.removeBlogClassificationTest(classification6);
    }

    /**
     * @description 测试findBlogClassification方法，通过博客id和类别查询记录
     * @param blogClassification
     */
    private void findBlogClassificationTest(BlogClassification blogClassification){
        try {
            if (DAOFactory.getBlogClassificationDAOInstance().findBlogClassification(blogClassification)){
                System.out.println("findBlogClassification方法测试成功！！！\n");
            } else {
                System.out.println("findBlogClassification方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findBlogClassification方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findBlogClassificationList方法，查询所有分类
     */
    private void findBlogClassificationListByUidTest(User user){
        List<String> aidList = null;
        try {
            aidList = DAOFactory.getBlogClassificationDAOInstance().findBlogClassificationListByUid(user);
            if (aidList != null){
                System.out.println("findBlogClassificationList方法测试成功！！！"+"一共"+aidList.size()+"个类别：");
                Iterator<String> it = aidList.iterator();
                while(it.hasNext()){
                    System.out.println("        类别："+it.next());
                }
                System.out.println();
            } else {
                System.out.println("findBlogClassificationList方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findBlogClassificationList方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findBlogClassificationByBid方法，查询该博客的所属类别
     * @param blogClassification
     */
    private void findBlogClassificationByBidTest(BlogClassification blogClassification){
        List<String> aidList = null;
        try {
            aidList = DAOFactory.getBlogClassificationDAOInstance().findBlogClassificationByBid(blogClassification);
            if (aidList != null){
                System.out.println("findBlogClassificationByBid方法测试成功！！！"+"博客"+blogClassification.getBid()+"一共存在"+aidList.size()+"个类别：");
                Iterator<String> it = aidList.iterator();
                while(it.hasNext()){
                    System.out.println("        类别："+it.next());
                }
                System.out.println();
            } else {
                System.out.println("findBlogClassificationByBid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findBlogClassificationByBid方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findBlogByClassification方法，查询属于该类别的博客id列表
     * @param blogClassification
     */
    private void findBlogByClassificationTest(int currentPage,int record,BlogClassification blogClassification ){
        List<Integer> aidList = null;
        try {
            aidList = DAOFactory.getBlogClassificationDAOInstance().findBlogByClassification(currentPage,record,blogClassification);
            if (aidList != null){
                System.out.println("findBlogByClassification方法测试成功！！！");
                System.out.println("        页数："+currentPage+"  记录数："+aidList.size());
                Iterator<Integer> it = aidList.iterator();
                while(it.hasNext()){
                    System.out.println("        博客："+it.next().toString());
                }
                System.out.println();
            } else {
                System.out.println("findBlogByClassification方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findBlogByClassification方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试addBlogClassification方法，通过博客id和类别添加类别
     * @param blogClassification
     */
    private void addBlogClassificationTest(BlogClassification blogClassification){
        try {
            if (DAOFactory.getBlogClassificationDAOInstance().addBlogClassification(blogClassification)){
                System.out.println("addBlogClassification方法测试成功！！！");
                System.out.println("        "+blogClassification.getBid()+"添加了"+blogClassification.getClassification()+"类别\n");
            } else {
                System.out.println("addBlogClassification方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("addBlogClassification方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试removeBlogClassification方法，通过博客id和类别移除类别
     * @param blogClassification
     */
    private void removeBlogClassificationTest(BlogClassification blogClassification){
        try {
            if (DAOFactory.getBlogClassificationDAOInstance().removeBlogClassification(blogClassification)){
                System.out.println("removeBlogClassification方法测试成功！！！");
                System.out.println("        "+blogClassification.getBid()+"移除了"+blogClassification.getClassification()+"类别\n");
            } else {
                System.out.println("removeBlogClassification方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("removeBlogClassification方法测试失败！！！");
            e.printStackTrace();
        }
    }
}
