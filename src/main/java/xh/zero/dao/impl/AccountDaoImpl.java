package xh.zero.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import xh.zero.dao.AccountDao;

import javax.annotation.Resource;

public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outName, int money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, outName);
    }

    @Override
    public void in(String inName, int money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, inName);
    }
}
