package xh.zero.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xh.zero.dao.RoleDao;
import xh.zero.domain.Role;

import javax.annotation.Resource;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> findAll() {
        List<Role> roles = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roles;
    }

    @Override
    public void saveRole(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public void deleteRole(int id) {
        jdbcTemplate.update("delete from sys_role where id=?", id);
    }

    @Override
    public List<Role> findRowByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query(
                "select * from sys_user_role ur, sys_role r where ur.userId=? and ur.roleId=r.id",
                new BeanPropertyRowMapper<Role>(Role.class),
                id
        );
        return roles;
    }
}
