/**
 * Github address:
 * @Title: CollectionTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/26 0:16 AM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.Collection;
import com.myblog.blog.vo.User;

import java.util.Iterator;
import java.util.List;

/**
 * @className: CollectionTest
 * @description: 测试CollectionDAOProxy中的方法
 * @author: ZSZ
 * @date: 2019/7/26 0:16 AM
 */
public class CollectionTest {

    public static void main(String[] args) {
        CollectionTest test = new CollectionTest();
        Collection collection1 = new Collection(2018211261,1);
        Collection collection2 = new Collection(2018211261,2);
        test.addCollectionTest(collection1);
        test.addCollectionTest(collection2);
        test.findByUidAndBidTest(collection1);
        test.findCollectionListByUidTest(new User(2018211261));
        test.removeByUidAndBidTest(collection2);

    }

    /**
     * @description 测试findByUidAndBid方法，通过用户id和博客id查询
     * @param collection
     */
    private void findByUidAndBidTest(Collection collection){
        try {
            if (DAOFactory.getCollectionDAOInstance().findByUidAndBid(collection)){
                System.out.println("findByUidAndBid方法测试成功！！！");
                System.out.println("用户"+collection.getUid()+"收藏了博客"+collection.getBid()+"\n");
            }else {
                System.out.println("findByUidAndBid方法测试失败！！！");
            }
        } catch (Exception e){
            System.out.println("findByUidAndBid方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findCollectionListByUid方法，通过用户id查询该用户收藏的博客id列表
     * @param user
     */
    private void findCollectionListByUidTest(User user){
        List<Integer> bidList = null;
        try {
            bidList = DAOFactory.getCollectionDAOInstance().findCollectionListByUid(user);
            if (bidList != null){
                System.out.println("findCollectionListByUid方法测试成功！！！一个收藏"+bidList.size()+"篇博客");
                Iterator<Integer> it = bidList.iterator();
                while(it.hasNext()){
                    System.out.println("        博客："+it.next().toString());
                }
            }else {
                System.out.println("findCollectionListByUid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findCollectionListByUid方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试addCollection方法，通过用户id和博客id增加收藏
     * @param collection
     */
    private void addCollectionTest(Collection collection){
        try {
            if (DAOFactory.getCollectionDAOInstance().addCollection(collection)){
                System.out.println("addCollection方法测试成功！！！");
                System.out.println("用户"+collection.getUid()+"收藏了博客"+collection.getBid()+"\n");
            }else {
                System.out.println("addCollection方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("addCollection方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试removeByUidAndBid方法，通过用户id和博客id取消收藏
     * @param collection
     */
    private void removeByUidAndBidTest(Collection collection){
        try {
            if (DAOFactory.getCollectionDAOInstance().removeByUidAndBid(collection)){
                System.out.println("removeByUidAndBid方法测试成功！！！");
                System.out.println("用户"+collection.getUid()+"取消了收藏博客"+collection.getBid()+"\n");
            }else {
                System.out.println("removeByUidAndBid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("removeByUidAndBid方法测试失败！！！");
            e.printStackTrace();
        }
    }
}
