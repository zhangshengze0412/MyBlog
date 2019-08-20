/**
 * GitHub address:
 * @Title: DataFactory.java
 * @Package com.myblog.blog.factory
 * @Description: 工厂包
 * @author: ZSZ
 * @date: 2019/7/24 17:34 PM
 * @version 1.0
 *
 */
package com.myblog.blog.factory;

import com.myblog.blog.dao.*;
import com.myblog.blog.dao.proxy.*;

/**
 * @className DataFactory
 * @descri[tion DAO工厂类
 * author：ZSZ
 * time：2019/7/24 17:35 PM
 */
public class DAOFactory {

    public static IUserDAO getUserDAOInstance() throws Exception {
        return new UserDAOProxy();
    }

    public static IBlogDAO getBlogDAOInstance() throws Exception {
        return new BlogDAOProxy();
    }

    public static IReviewDAO getReviewDAOInstance() throws Exception {
        return new ReviewDAOProxy();
    }

    public static IThumbUpDAO getThumbUpDAOInstance() throws Exception {
        return new ThumbUpDAOProxy();
    }

    public static IAttentionDAO getAttentionDAOInstance() throws Exception {
        return new AttentionDAOProxy();
    }

    public static ICollectionDAO getCollectionDAOInstance() throws Exception {
        return new CollectionDAOProxy();
    }

    public static IBlogClassificationDAO getBlogClassificationDAOInstance() throws Exception {
        return new BlogClassificationDAOProxy();
    }

}
