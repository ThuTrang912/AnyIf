package sk2a.hello.chann.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import sk2a.hello.chann.domain.User;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{

    private final SqlSession sqlSession;

    private static final String namespace = "sk2a.hello.chann.dao.UserDao.";

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getAllUsers() {
        return sqlSession.selectList(namespace + "getAllUsers");
    }


}
