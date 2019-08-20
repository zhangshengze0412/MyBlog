/**
 * GitHub address:
 * @Title: MySQLDatabaseConnection.java
 * @Package com.myblog.blog.dbc
 * @Description: 获取数据库连接并关闭
 * @author: ZSZ
 * @date: 2019/7/23 19:54 PM
 * @version 1.0
 *
 */
package com.myblog.blog.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @className MySQLDatabaseConnection
 * @description 实现了IDataBaseConnection,
 *              具体使用MySQL为数据库，
 *              定义实现了连接数据库获取连接并关闭连接的方法
 * @author ZSZ
 * @data 2019/7/23 20:02 PM
 */
public class MySQLDatabaseConnection implements IDatabaseConnection{

    private static String DBDRIVER = "com.mysql.jdbc.Driver";
    private static String DBURL="jdbc:mysql://localhost:3306/blog?useSSL=false&characterEncoding=utf8";
    private static String DBUSER="root";
    private static String DBPASSWORD="12141x";
    private static Connection conn =null;

    public MySQLDatabaseConnection() throws Exception{
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
    }

    @Override
    public Connection getConnection() throws Exception {
        return conn;
    }

    @Override
    public void Close() throws Exception {
        if(conn!=null){
            conn.close();
        }
    }
}
