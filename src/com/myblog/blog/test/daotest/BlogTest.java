/**
 * Github address:
 * @Title: BlogTest.java
 * @package: com.myblog.blog.test.daotest
 * @description: 测试各个数据库代理类
 * @author：ZSZ
 * @date：2019/7/25 17:31 PM
 * @version 1.0
 */
package com.myblog.blog.test.daotest;

import com.myblog.blog.factory.DAOFactory;
import com.myblog.blog.vo.Blog;
import com.myblog.blog.vo.User;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

/**
 * @className BlogTest
 * @description 测试BlogDAOProxy类
 * @author ZSZ
 * @date 2019/7/25 17:31 PM
 */
public class BlogTest {
    public static void main(String[] args) {
        BlogTest test = new BlogTest();
        //Blog a = new Blog(2018211261,"Numpy数据存取与函数","zsz",new Date(),"Numpy数据存取与函数",19,3);
        //Blog b = new Blog(2018211261,"Numpy入门","zsz",new Date(),"Numpy入门",20,5);
        //Blog c = new Blog(2018211261,"JAVA IO——字节流","zsz",new Date(),"JAVA IO——字节流",32,6);
        //test.removeBlogByIdTest(new Blog(5));
        //test.addBlogTest(a);
        //test.addBlogTest(b);
        //test.addBlogTest(c);
        //test.findBlogByIdTest(new Blog(1));
        //test.findBlogByTitleTest(new Blog("Numpy数据存取与函数"));
        //test.findBlogListByUidTest(1,2,new User(2018211261));
        //test.findBlogListBySeeTest(1,2);
        //test.findBlogListByTimeTest(1,2);
        //test.findBlogListByKeyTest("Numpy");
        //test.findBlogListByKeyTest("JAVA");
        //Blog newA = new Blog(1,2018211261,"Numpy数据存取与函数","zsz",new Date(),"Numpy数据存取与函数assfcsd",19,3);
        //test.updateBlogTest(newA);
        //test.findBlogListByTimeTest(1,2);
        test.findBlogNumTest();
        test.findBlogNumByUidTest(new User(2018211261));
        test.findBlogByUidAndTitleTest(new Blog(2018211261,"Numpy入门"));
        test.findBlogByUidAndBidTest(new Blog(1,2018211261));
    }

    /**
     * @description 测试通过findBlogById方法，通过博客id查询
     * @param blog
     */
    private void findBlogByIdTest(Blog blog){
        Blog blog1;
        try {
            blog1 = DAOFactory.getBlogDAOInstance().findBlogById(blog);
            if (blog1 != null){
                System.out.println("findBlogById方法测试成功！！！查询到的博客名为："+blog1.getTitle());
            } else {
                System.out.println("findBlogById方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogByUidAndBid方法，通过用户id和博客id查询
     * @param blog
     */
    private void findBlogByUidAndBidTest(Blog blog){
        Blog blog1;
        try {
            blog1 = DAOFactory.getBlogDAOInstance().findBlogByUidAndBid(blog);
            if (blog1 != null){
                System.out.println("findBlogByUidAndBid方法测试成功！！！查询到的博客名为："+blog1.getTitle());
            } else {
                System.out.println("findBlogByUidAndBid方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogByUidAndTitle方法，通过用户id和博客title查询
     * @param blog
     */
    private void findBlogByUidAndTitleTest(Blog blog){
        Blog blog1;
        try {
            blog1 = DAOFactory.getBlogDAOInstance().findBlogByUidAndTitle(blog);
            if (blog1 != null){
                System.out.println("findBlogByUidAndTitle方法测试成功！！！查询到的博客名为："+blog1.getTitle());
            } else {
                System.out.println("findBlogByUidAndTitle方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogByTitle方法，通过博客title查询
     * @param blog
     */
    private void findBlogByTitleTest(Blog blog){
        Blog blog1;
        try {
            blog1 = DAOFactory.getBlogDAOInstance().findBlogByTitle(blog);
            if (blog1 != null){
                System.out.println("findBlogByTitle方法测试成功！！！查询到的博客id为："+blog1.getId());
            } else {
                System.out.println("findBlogByTitle方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过addBlog方法，添加blog
     * @param blog
     */
    private void addBlogTest(Blog blog){
        try {
            DAOFactory.getBlogDAOInstance().addBlog(blog);
            System.out.println("addBlog方法测试成功！！！");
        } catch (Exception e){
            System.out.println("addBlog方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过removeBlogById方法，删除blog
     * @param blog
     */
    private void removeBlogByIdTest(Blog blog){
        try {
            DAOFactory.getBlogDAOInstance().removeBlogById(blog);
            System.out.println("removeBlogById方法测试成功！！！");
        } catch (Exception e){
            System.out.println("removeBlogById方法测试失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过updateBlog方法，更新blog信息
     * @param blog
     */
    private void updateBlogTest(Blog blog){
        Blog blog1;
        try {
            blog1 = DAOFactory.getBlogDAOInstance().updateBlog(blog);
            if (blog1 != null){
                System.out.println("updateBlog方法测试成功！！！更新后的博客的创建时间为："+new Timestamp(blog.getTime().getTime()));
            } else {
                System.out.println("updateBlog方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogListBySee方法，根据浏览人数降序
     * @param currentPage
     * @param recode
     */
    private void findBlogListBySeeTest(int currentPage, int recode){
        List<Blog> blogList;
        try {
            blogList = DAOFactory.getBlogDAOInstance().findBlogListBySee(currentPage,recode);
            if (blogList != null){
                System.out.println("findBlogListBySee方法测试成功！！！当前页数为："+currentPage+" 记录数："+blogList.size());
                Iterator<Blog> it = blogList.iterator();
                while (it.hasNext()){
                    Blog aBlog = it.next();
                    System.out.println("        标题："+aBlog.getTitle()+"  作者："+aBlog.getAuthor()+"  创建时间："+aBlog.getTime()+"    内容："+aBlog.getContext()+"  浏览人数："+aBlog.getSee()+"    点赞人数："+aBlog.getThumbup());
                }
            } else {
                System.out.println("findBlogListBySee方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogListByTime方法，根据时间降序
     * @param currentPage
     * @param recode
     */
    private void findBlogListByTimeTest(int currentPage, int recode){
        List<Blog> blogList;
        try {
            blogList = DAOFactory.getBlogDAOInstance().findBlogListByTime(currentPage,recode);
            if (blogList != null){
                System.out.println("findBlogListByTime方法测试成功！！！当前页数为："+currentPage+" 记录数："+blogList.size());
                Iterator<Blog> it = blogList.iterator();
                while (it.hasNext()){
                    Blog aBlog = it.next();
                    System.out.println("        标题："+aBlog.getTitle()+"  作者："+aBlog.getAuthor()+"  创建时间："+aBlog.getTime()+"    内容："+aBlog.getContext()+"  浏览人数："+aBlog.getSee()+"    点赞人数："+aBlog.getThumbup());
                }
            } else {
                System.out.println("findBlogListByTime方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogListByKey方法，根据关键字查询
     * @param key
     */
    private void findBlogListByKeyTest(String key){
        List<Blog> blogList;
        try {
            blogList = DAOFactory.getBlogDAOInstance().findBlogListByKey(key);
            if (blogList != null){
                System.out.println("findBlogListByKey方法测试成功！！！"+" 查询到："+blogList.size()+"篇博客");
                Iterator<Blog> it = blogList.iterator();
                while (it.hasNext()){
                    Blog aBlog = it.next();
                    System.out.println("        标题："+aBlog.getTitle()+"  作者："+aBlog.getAuthor()+"  创建时间："+aBlog.getTime()+"    内容："+aBlog.getContext()+"  浏览人数："+aBlog.getSee()+"    点赞人数："+aBlog.getThumbup());
                }
            } else {
                System.out.println("findBlogListByKey方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试通过findBlogListByUid方法，根据用户查询
     * @param currentPage
     * @param recode
     */
    private void findBlogListByUidTest(int currentPage, int recode, User user){
        List<Blog> blogList;
        try {
            blogList = DAOFactory.getBlogDAOInstance().findBlogListByUid(currentPage,recode,user);
            if (blogList != null){
                System.out.println("findBlogListByUid方法测试成功！！！"+" 查询到："+blogList.size()+"篇博客");
                Iterator<Blog> it = blogList.iterator();
                while (it.hasNext()){
                    Blog aBlog = it.next();
                    System.out.println("        标题："+aBlog.getTitle()+"  作者："+aBlog.getAuthor()+"  创建时间："+aBlog.getTime()+"    内容："+aBlog.getContext()+"  浏览人数："+aBlog.getSee()+"    点赞人数："+aBlog.getThumbup());
                }
            } else {
                System.out.println("findBlogListByUid方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findBlogNum方法，返回博客总数
     */
    private void findBlogNumTest(){
        int num = 0;
        try {
            num = DAOFactory.getBlogDAOInstance().findBlogNum();
            if (num != 0){
                System.out.println("findBlogNum方法测试成功！！！"+ "一共存在："+num+"篇博客！");
            } else {
                System.out.println("findBlogNum方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 测试findBlogNumByUid方法，返回该用户的博客总数！
     * @param user
     */
    private void findBlogNumByUidTest(User user){
        int num = 0;
        try {
            num = DAOFactory.getBlogDAOInstance().findBlogNumByUid(user);
            if (num != 0){
                System.out.println("findBlogNumByUid方法测试成功！！！"+ "用户"+user.getId()+"一共存在："+num+"篇博客！");
            } else {
                System.out.println("findBlogNumByUid方法测试失败！！！");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
