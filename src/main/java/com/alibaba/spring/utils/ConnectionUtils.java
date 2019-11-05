package com.alibaba.spring.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类,它用于从数据库中获取一个连接,并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程池上的连接
     */
    public Connection getThreadConnection(){
        try {
            Connection conn = t1.get();
            //判断当前线程上是否有连接
            if(conn == null){
             conn = dataSource.getConnection();
             t1.set(conn);
            }
            //返回当前线程上的连接
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放连接
     */
    public void removeConnection(){
        t1.remove();
    }
}
