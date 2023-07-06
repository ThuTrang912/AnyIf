package sk2a.hello.chann.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Page;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;


    public Page<Board> getBoardByPage(int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        List<Board> data = boardDao.getBoardsByPage(startRow, pageSize);
        long totalItems = boardDao.getTotalBoardCount();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Page<Board> result = new Page<>();
        result.setData(data);
        result.setCurrentPage(page);
        result.setTotalPages(totalPages);
        result.setPageSize(pageSize);
        result.setTotalItems(totalItems);

        return result;
    }
}
