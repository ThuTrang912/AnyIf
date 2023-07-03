package sk2a.hello.chann.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import sk2a.hello.chann.domain.Board;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{

    private final SqlSession sqlSession;
    private final static String namespace = "sk2a.hello.chann.dao.BoardDao.";

    @Override
    public List<Board> getAllBoards() {
        return sqlSession.selectList(namespace + "getAllBoards");
    }

//    @Override
//    public List<Board> getSearchBoards(String search) {
//        return sqlSession.selectList(namespace + "getSearchBoards", search);
//    }

}
