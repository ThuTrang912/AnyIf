package sk2a.hello.chann.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Page;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageService {
    private final BoardDao boardDao;

    public Page<Board> getBoardByPage(int page, int pageSize, int navSize, String search, String category, String price, String time) {
        int startRow = (page - 1) * pageSize;
        List<Board> data = boardDao.getBoardsByPage(startRow, pageSize, search, category, price, time);
        long totalItems = boardDao.getTotalBoardCount(search, category, price, time);
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Page<Board> result = new Page<>();
        result.setData(data);
        result.setCurrentPage(page);
        result.setTotalPages(totalPages);
        result.setPageSize(pageSize);
        result.setNavSize(navSize);
        result.setTotalItems(totalItems);

        return result;
    }
}
