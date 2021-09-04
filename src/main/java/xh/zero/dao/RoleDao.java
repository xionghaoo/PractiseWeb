package xh.zero.dao;

import xh.zero.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    void saveRole(Role role);

    void deleteRole(int id);

    List<Role> findRowByUserId(Long id);
}
