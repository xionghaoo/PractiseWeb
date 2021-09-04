package xh.zero.service;

import xh.zero.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void saveUser(User user, Long[] roleIds);

    void delete(Long userId);

    User login(String username, String password);
}
