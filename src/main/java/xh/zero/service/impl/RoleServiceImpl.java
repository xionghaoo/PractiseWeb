package xh.zero.service.impl;

import xh.zero.dao.RoleDao;
import xh.zero.domain.Role;
import xh.zero.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role> list() {
        List<Role> roles = roleDao.findAll();
        return roles;
    }
}
