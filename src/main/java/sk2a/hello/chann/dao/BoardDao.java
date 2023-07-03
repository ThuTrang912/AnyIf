package sk2a.hello.chann.dao;

import org.apache.ibatis.annotations.Mapper;
import sk2a.hello.chann.domain.Board;

import java.util.List;

//@Mapper
public interface BoardDao {
    List<Board> getAllBoards();
    List<Board> getSearchBoards(String search);
}
