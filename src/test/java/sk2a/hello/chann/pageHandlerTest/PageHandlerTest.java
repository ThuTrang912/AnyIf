package sk2a.hello.chann.pageHandlerTest;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sk2a.hello.chann.pagination.Page;


public class PageHandlerTest {

    @Test
    public void hello() {

        Page page = new Page<>(33);
        Integer totalPage =  page.getTotalPages();
        System.out.println("totalPage=" +  totalPage); // 4
        Assertions.assertThat(4).isEqualTo(totalPage);
    }
}
