package com.alibaba.spring.service.impl;

import com.alibaba.spring.dao.AccountDao;
import com.alibaba.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户的业务层实现类
 */
@Service
@Transactional(isolation= Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String from, String to, Double money) {
        accountDao.out(from, money);
        accountDao.in(to,money);
    }
}
