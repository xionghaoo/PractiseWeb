package xh.zero.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import xh.zero.dao.AccountDao;
import xh.zero.service.AccountService;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = false)
    @Override
    public void transfer(String outName, String inName, int money) {
        accountDao.out(outName, money);
        accountDao.in(inName, money);
    }
}
