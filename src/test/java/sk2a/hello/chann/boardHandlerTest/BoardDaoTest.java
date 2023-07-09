package sk2a.hello.chann.boardHandlerTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;

import java.util.List;


public class BoardDaoTest {
    private BoardDao boardDao;
    @Test
    public void testGetBoardsByPage() {
        // Prepare test data
        int pageSize = 2;
        int page = 1; // Assuming the first page

        // Call the method to be tested
        List<Board> boards = boardDao.getBoardsByPage((page - 1) * pageSize, pageSize);

        // Assertions
        Assertions.assertThat(boards).isNotNull();
        Assertions.assertThat(boards).hasSize(pageSize);
        // Add more assertions as per your requirements
    }
}