package sk2a.hello.chann.pageHandlerTest;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Page;

import java.util.List;


@SpringBootTest
public class PageHandlerTest {
    @Test
    public void getTotalPageTest() {
        Page page = new Page<>(100);
        Integer totalPage =  page.getTotalPages();
        System.out.println("totalPage=" +  totalPage); // 4
        Assertions.assertThat(4).isEqualTo(totalPage);
    }


}
