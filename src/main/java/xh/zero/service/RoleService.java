package xh.zero.service;

import xh.zero.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();

    void saveRole(Role role);

    void deleteRole(int id);
}
