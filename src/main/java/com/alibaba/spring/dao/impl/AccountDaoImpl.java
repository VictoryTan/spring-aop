package com.alibaba.spring.dao.impl;

import com.alibaba.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void out(String from, double money) {
        jdbcTemplate.update("UPDATE account SET money = money - ? WHERE name = ?", money, from);
    }

    public void in(String to, double money) {
        jdbcTemplate.update("UPDATE account SET money = money + ? WHERE name = ?", money, to);
    }
}
