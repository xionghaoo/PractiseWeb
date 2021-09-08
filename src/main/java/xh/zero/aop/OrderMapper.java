package xh.zero.aop;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import xh.zero.domain.User;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "order_time", property = "order_time"),
            @Result(column = "order_no", property = "order_no"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "xh.zero.aop.UserMapper.findById")
            )
    })
    List<Order> findAll();

    @Select("select * from orders where uid = #{id}")
    List<Order> findOrderByUserId(int id);
}
