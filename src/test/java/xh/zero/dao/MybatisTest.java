package xh.zero.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xh.zero.aop.UserMapper;
import xh.zero.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = userMapper.findAll();
//        System.out.println(users);
//        User user = new User();
//        user.setUsername("xixihaha");
//        user.setPassword("123456");
//        user.setEmail("xx@12.45");
//        userMapper.save(user);
        User user = userMapper.findById(2);
        System.out.println(user);
        sqlSession.close();
    }
}
