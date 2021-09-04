package xh.zero.service.impl;

import xh.zero.dao.RoleDao;
import xh.zero.dao.UserDao;
import xh.zero.domain.Role;
import xh.zero.domain.User;
import xh.zero.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> users = userDao.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            Long id = user.getId();
            List<Role> roles = roleDao.findRowByUserId(id);
            user.setRoles(roles);
        }
        return users;
    }

    @Override
    public void saveUser(User user, Long[] roleIds) {
        userDao.saveUser(user, roleIds);
    }

    @Override
    public void delete(Long userId) {
        userDao.delete(userId);
    }
}
