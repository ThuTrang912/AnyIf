package sk2a.hello.chann.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk2a.hello.chann.domain.Board;

import java.util.List;

//@Mapper
public interface BoardDao {
    List<Board> getAllBoards();
    List<Board> getBoardsBySearch(String search);
    List<Board> getBoardsByPage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);
    long getTotalBoardCount();
}
