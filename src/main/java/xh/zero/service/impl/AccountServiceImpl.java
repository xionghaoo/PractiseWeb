package xh.zero.service.impl;

import xh.zero.dao.AccountDao;
import xh.zero.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outName, String inName, int money) {
        accountDao.out(outName, money);
//        int a = 1/0;
        accountDao.in(inName, money);
    }
}
