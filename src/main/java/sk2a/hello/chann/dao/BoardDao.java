package sk2a.hello.chann.dao;

import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Product;

import java.util.List;

public interface BoardDao {
    List<Board> getBoardsByPage(int startRow, int pageSize, String search, String category, String price, String time);

    long getTotalBoardCount(String search, String category, String price, String time);
}
