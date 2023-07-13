package sk2a.hello.chann.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Product;

import java.util.List;

//@Mapper
public interface BoardDao {
    List<Board> getBoardsByPage(
            @Param("startRow") int startRow,
            @Param("pageSize") int pageSize,
            @Param("search") String search,
            @Param("category") String category,
            @Param("price") String price,
            @Param("time") String time
    );

    long getTotalBoardCount(
            @Param("search") String search,
            @Param("category") String category,
            @Param("price") String price,
            @Param("time") String time
    );
}
