package xh.zero.aop;

import org.apache.ibatis.annotations.*;
import xh.zero.domain.User;

import java.util.List;

public interface UserMapper {
    @Insert("insert into sys_user values (null, #{username}, #{email}, #{password}, #{phoneNum}, #{birthday})")
    public void save(User user);

    @Select("select * from sys_user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            @Result(
                    property = "orders",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "xh.zero.aop.OrderMapper.findOrderByUserId")
            )
    })
    public List<User> findAll();

    @Select("select * from sys_user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            @Result(
                    property = "roles",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "xh.zero.aop.RoleMapper.findAllByUserId")
            )
    })
    public List<User> findAllWithRoles();

    @Select("select * from sys_user where id = #{id}")
    public User findById(int id);

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);
}
