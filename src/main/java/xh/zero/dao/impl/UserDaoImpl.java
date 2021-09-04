package xh.zero.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import xh.zero.dao.UserDao;
import xh.zero.domain.User;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        List<User> users = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void saveUser(User user, Long[] roleIds) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
//        jdbcTemplate.update(
//                "insert into sys_user values(?,?,?,?,?)",
//                null,
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getPhoneNum()
//        );
        if (keyHolder.getKey() != null) {
            for (int i = 0; i < roleIds.length; i++) {
                Long id = roleIds[i];
                jdbcTemplate.update("insert into sys_user_role values(?,?)", keyHolder.getKey().longValue(), id);
            }
        }
    }

    @Override
    public void delete(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);
        jdbcTemplate.update("delete from sys_user where id=?", userId);
    }
}
