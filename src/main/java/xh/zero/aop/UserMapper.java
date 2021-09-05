package xh.zero.aop;

import xh.zero.domain.User;

import java.util.List;

public interface UserMapper {
    public void save(User user);
    public List<User> findAll();
    public User findById(int id);
}
