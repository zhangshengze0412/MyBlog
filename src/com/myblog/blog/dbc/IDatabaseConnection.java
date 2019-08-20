/**
 * GitHub address:
 * @Title: IDatabaseConnection.java
 * @Package com.myblog.blog.dbc
 * @Description: 获取数据库连接并关闭
 * @author: ZSZ
 * @date: 2019/7/23 19:54 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dbc;

import java.sql.Connection;

/**
 * @ClassName IDatabaseConnection
 * @Description 定义获取数据库连接方法
 * @author ZSZ
 * @data 2019/7/23 19:54 PM
 */
public interface IDatabaseConnection {

    /**
     * @description 获取数据库连接
     * @return Connection对象
     * @throws Exception
     */
    public Connection getConnection() throws Exception;

    /**
     * @description关闭数据库连接
     * @throws Exception
     */
    public void Close() throws Exception;
}
