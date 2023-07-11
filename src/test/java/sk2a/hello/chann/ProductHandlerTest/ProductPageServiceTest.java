package sk2a.hello.chann.ProductHandlerTest;

import org.apache.ibatis.annotations.Delete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk2a.hello.chann.dao.ProductDao;
import sk2a.hello.chann.pagination.Page;
import sk2a.hello.chann.pagination.Product;
import sk2a.hello.chann.service.PageService;

import java.util.List;

public class ProductPageServiceTest {
    private PageService pageService;
    private ProductDao productDao;
//    @Test
//    public void testGetProductByPage(){
//        int page = 1;
//        int pageSize = 12;
//
//        Page<Product> productsPage = pageService.getProductByPage(page,12);
//        List<Product> products = new List<Product>(100);
//
//        List<Product> productsPerpage = productsPage.getData();
//
//
//    }

}
