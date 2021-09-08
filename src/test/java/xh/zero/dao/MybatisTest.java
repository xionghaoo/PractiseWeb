package xh.zero.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xh.zero.aop.Order;
import xh.zero.aop.OrderMapper;
import xh.zero.aop.UserMapper;
import xh.zero.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<User> users = userMapper.findAllWithRoles();
        System.out.println(users);

//        User user = new User();
////        user.setId(7L);
//        user.setUsername("rose");
//        user.setPassword("123453");
//        user.setEmail("weq@erw.com");
//        user.setBirthday(new Date());
//        userMapper.save(user);

//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(2);
//        List<User> users = userMapper.findByIds(ids);

//        List<User> users = userMapper.findByCondition(user);

//        PageHelper.startPage(2, 2);
//        List<User> r = userMapper.findAll();
//        for (int i = 0; i < r.size(); i++) {
//            System.out.println(r.get(i));
//        }
//        PageInfo<User> pageInfo = new PageInfo<>(r);
//        System.out.println("current page: " + pageInfo.getPageNum());
//        System.out.println("total page: " + pageInfo.getPages());
//        System.out.println("total num: " + pageInfo.getTotal());

//        List<Order> orders = orderMapper.findAll();
//        System.out.println(orders);

//        List<User> users = userMapper.findAll();
//        User user = userMapper.findById(2);
//        System.out.println(user);

        sqlSession.close();
    }
}
