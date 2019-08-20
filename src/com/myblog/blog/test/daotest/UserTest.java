/**
 * Github address:
 * @Title: UserTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/25 16:45 PM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.User;

import java.util.Iterator;
import java.util.List;

/**
 * @className UserTest
 * @description 测试UserDAOProxy类
 * @author ZSZ
 * @date 2019/7/25 16:45 PM
 */
public class UserTest {

    public static void main(String[] args) {
        UserTest test = new UserTest();
//        User user = new User(2018211261,"zsz","123456","男","13516964920","2955324023@qq.com",1,null,1);
//        User newUser = new User(2018211261,"zsz","123456","男","13516964920","2955324023@qq.com",1,null,0);
//        test.removeUserByIdTest(user);
//        test.addUserTest(user);
//        test.checkLoginTest(new User(2018211261,"123456"));
        test.findUserByIdTest(new User(2018211261));
//        test.findUserByNameTest(new User("zsz"));
//        test.updateUserTest(newUser);
//        test.findUserTest(1,10);
        test.findUserNumTest();
    }

    /**
     * @description 测试通过findUserById方法，通过用户id查询
     * @param user
     */
    private void findUserByIdTest(User user){
        User user1;
        try {
            user1 = DAOFactory.getUserDAOInstance().findUserById(user);
            if (user1 != null){
                System.out.println("findUserById方法测试成功！！！查询到的用户名为："+user1.getUsername());
            } else {
                System.out.println("findUserById方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findUserByName方法，通过用户username查询
     * @param user
     */
    private void findUserByNameTest(User user){
        User user1;
        try {
            user1 = DAOFactory.getUserDAOInstance().findUserByName(user);
            if (user1 != null){
                System.out.println("findUserByName方法测试成功！！！查询到的用户id为："+user1.getId());
            } else {
                System.out.println("findUserByName方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试addUser方法，向数据库添加用户
     * @param user
     */
    private void addUserTest(User user){
        try {
            DAOFactory.getUserDAOInstance().addUser(user);
            System.out.println("addUser方法测试成功！！！");
        } catch (Exception e){
            System.out.println("addUser方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试removeUserById方法，向数据库删除用户
     * @param user
     */
    private void removeUserByIdTest(User user){
        try {
            DAOFactory.getUserDAOInstance().removeUserById(user);
            System.out.println("removeUserById方法测试成功！！！");
        } catch (Exception e){
            System.out.println("removeUserById方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过updateUser方法，更新用户数据
     * @param user
     */
    private void updateUserTest(User user){
        User newUser;
        try {
            newUser = DAOFactory.getUserDAOInstance().updateUser(user);
            if (newUser != null){
                System.out.println("updateUser方法测试成功！！！更新后的用户名为："+newUser.getUsername());
            } else {
                System.out.println("updateUser方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过checkLogin方法，检查用户id和密码是否匹配
     * @param user
     */
    private void checkLoginTest(User user){
        User user1;
        try {
            user1 = DAOFactory.getUserDAOInstance().checkLogin(user);
            if (user1 != null){
                System.out.println("checkLogin方法测试成功！！！登录的用户名为："+user1.getUsername());
            } else {
                System.out.println("checkLogin方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findUser方法，分页查询用户数据
     * @param currentPage
     * @param recode
     */
    private void findUserTest(int currentPage, int recode){
        List<User> userList;
        try {
            userList = DAOFactory.getUserDAOInstance().findUser(currentPage,recode);
            if (userList != null){
                System.out.println("findUser方法测试成功！！！当前页数为："+currentPage+" 记录数："+userList.size());
                Iterator<User> it = userList.iterator();
                while(it.hasNext()){
                    System.out.println("        用户名："+it.next().getUsername());
                }
            } else {
                System.out.println("findUser方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findUserNum方法，返回用户总数！
     */
    private void findUserNumTest(){
        int num = 0;
        try {
            num = DAOFactory.getUserDAOInstance().findUserNum();
            if (num != 0){
                System.out.println("findUserNum方法测试成功！！！"+ "一共存在："+num+"个用户！");
            } else {
                System.out.println("findUserNum方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
