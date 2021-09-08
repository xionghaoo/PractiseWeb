package xh.zero.aop;

import org.apache.ibatis.annotations.Select;
import xh.zero.domain.Role;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_role r, sys_user_role ur where r.id = ur.roleId and ur.userId=#{uid}")
    public List<Role> findAllByUserId(int uid);
}
