package sk2a.hello.chann.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import sk2a.hello.chann.domain.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{

    private final SqlSession sqlSession;
    private final static String namespace = "sk2a.hello.chann.dao.BoardDao.";

    @Override
    public List<Board> getAllBoards() {
        return sqlSession.selectList(namespace + "getAllBoards");
    }

    @Override
    public List<Board> getBoardsBySearch(String search) {
        return sqlSession.selectList(namespace + "getBoardsBySearch", search);
    }

    @Override
    public List<Board> getBoardsByPage(int startRow, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRow", startRow);
        params.put("pageSize", pageSize);
        return sqlSession.selectList(namespace + "getBoardsByPage", params);
    }

    @Override
    public long getTotalBoardCount() {
        return sqlSession.selectOne(namespace + "getTotalBoardCount");
    }

}
