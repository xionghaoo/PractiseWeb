package xh.zero.dao;

import xh.zero.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void saveUser(User user, Long[] roleIds);

    void delete(Long userId);

    User findUserByUsernameAndPassword(String username, String password);
}
