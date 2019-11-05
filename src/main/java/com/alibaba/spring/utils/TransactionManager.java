/*
package com.alibaba.spring.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Aspect
@Component
public class TransactionManager {

    private ConnectionUtils connectionUtils;
*/
/**//*

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    */
/**
     * 开启事务
     *//*

    @Before(exc)
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 提交事务
     *//*

    @AfterReturning
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 回滚事务
     *//*

    @AfterThrowing
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 释放事务
     *//*

    @After()
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/
