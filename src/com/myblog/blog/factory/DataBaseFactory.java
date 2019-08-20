/**
 * GitHub address:
 * @Title: DataBaseFactory.java
 * @Package com.myblog.blog.factory
 * @Description: 工厂包
 * @author: ZSZ
 * @date: 2019/7/23 21:41 PM
 * @version 1.0
 *
 */
package com.myblog.blog.factory;

import com.myblog.blog.dbc.IDatabaseConnection;
import com.myblog.blog.dbc.MySQLDatabaseConnection;


/**
 * @className DataBaseFactory
 * @descri[tion 数据库工厂类，返回一个IDataBaseConnection对象
 * author：ZSZ
 * time：2019/7/23 21:43 PM
 */
public class DataBaseFactory {

    /**
     * @description 返回一个IDataBaseConnection对象
     * @return IDataBaseConnection
     * @throws Exception
     */
    public static IDatabaseConnection getDataBaseConnection() throws Exception {
        return new MySQLDatabaseConnection();
    }
}
