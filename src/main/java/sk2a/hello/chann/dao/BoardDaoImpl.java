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
public class BoardDaoImpl implements BoardDao {

    private final SqlSession sqlSession;
    private static final String namespace = "sk2a.hello.chann.dao.BoardDao.";

    @Override
    public List<Board> getBoardsByPage(int startRow, int pageSize, String search, String category, String price, String time) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRow", startRow);
        params.put("pageSize", pageSize);
        params.put("search", search);
        params.put("category", category);
        params.put("price", price);
        params.put("time", time);
        return sqlSession.selectList(namespace + "getBoardsByPage", params);
    }

    @Override
    public long getTotalBoardCount(String search, String category, String price, String time) {
        Map<String, Object> params = new HashMap<>();
        params.put("search", search);
        params.put("category", category);
        params.put("price", price);
        params.put("time", time);
        return sqlSession.selectOne(namespace + "getTotalBoardCount", params);
    }
}
