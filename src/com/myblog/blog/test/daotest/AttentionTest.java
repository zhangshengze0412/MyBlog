/**
 * Github address:
 * @Title: AttentionTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/26 0:42 AM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.Attention;
import com.myblog.blog.vo.User;

import java.util.Iterator;
import java.util.List;

/**
 * @className: AttentionTest
 * @description: 测试AttentionDAOProxy类
 * @author: ZSZ
 * @date: 2019/7/26 0:42 AM
 */
public class AttentionTest {

    public static void main(String[] args) {
        AttentionTest test = new AttentionTest();
        Attention attention1 =new Attention(2018211261,2018211260);
        Attention attention2 =new Attention(2018211261,2018211259);
        Attention attention3 =new Attention(2018211261,2018211262);
        test.addAttentionTest(attention1);
        test.addAttentionTest(attention2);
        test.addAttentionTest(attention3);
        test.findByUidAndAidTest(attention1);
        test.findAttentionListByUidTest(new User(2018211261));
        test.findFansListByUidTest(new User(2018211261));
        test.findFansListByUidTest(new User(2018211260));
        test.removeByUidAndAidTest(attention3);
    }

    /**
     * @description 测试findByUidAndAid方法，通过用户id和被关注用户id查询记录
     * @param attention
     */
    private void findByUidAndAidTest(Attention attention){
        try {
            if (DAOFactory.getAttentionDAOInstance().findByUidAndAid(attention)){
                System.out.println("findByUidAndAid方法测试成功！！！\n");
            } else {
                System.out.println("findByUidAndAid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findByUidAndAid方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findAttentionListByUid方法，查询该用户的关注列表
     * @param user
     */
    private void findAttentionListByUidTest(User user){
        List<Integer> aidList = null;
        try {
            aidList = DAOFactory.getAttentionDAOInstance().findAttentionListByUid(user);
            if (aidList != null){
                System.out.println("findAttentionListByUid方法测试成功！！！"+user.getId()+"一共关注了"+aidList.size()+"个人：");
                Iterator<Integer> it = aidList.iterator();
                while(it.hasNext()){
                    System.out.println("        用户："+it.next().toString());
                }
                System.out.println();
            } else {
                System.out.println("findAttentionListByUid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findAttentionListByUid方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findFansListByUid方法，查询该用户的粉丝列表
     * @param user
     */
    private void findFansListByUidTest(User user){
        List<Integer> aidList = null;
        try {
            aidList = DAOFactory.getAttentionDAOInstance().findFansListByUid(user);
            if (aidList != null){
                System.out.println("findFansListByUid方法测试成功！！！"+user.getId()+"一共有"+aidList.size()+"个粉丝：");
                Iterator<Integer> it = aidList.iterator();
                while(it.hasNext()){
                    System.out.println("        粉丝："+it.next().toString());
                }
                System.out.println();
            } else {
                System.out.println("findFansListByUid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("findFansListByUid方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试addAttention方法，通过用户id和被关注用户id添加关注
     * @param attention
     */
    private void addAttentionTest(Attention attention){
        try {
            if (DAOFactory.getAttentionDAOInstance().addAttention(attention)){
                System.out.println("addAttention方法测试成功！！！");
                System.out.println("        "+attention.getUid()+"关注了"+attention.getAid()+"\n");
            } else {
                System.out.println("addAttention方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("addAttention方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试removeByUidAndAid方法，通过用户id和被关注用户id取消关注
     * @param attention
     */
    private void removeByUidAndAidTest(Attention attention){
        try {
            if (DAOFactory.getAttentionDAOInstance().removeByUidAndAid(attention)){
                System.out.println("removeByUidAndAid方法测试成功！！！");
                System.out.println("        "+attention.getUid()+"取消了对"+attention.getAid()+"的关注\n");
            } else {
                System.out.println("removeByUidAndAid方法测试失败！！！\n");
            }
        } catch (Exception e){
            System.out.println("removeByUidAndAid方法测试失败！！！");
            e.printStackTrace();
        }
    }
}
