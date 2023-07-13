package sk2a.hello.chann.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk2a.hello.chann.dao.ProductDao;
import sk2a.hello.chann.pagination.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Data
public class TestController {

//    private final ProductDao productDao;
//
//    @GetMapping("/productTest")
//    public List<Product> test() {
//        List<Product> productsByPage = productDao.getProductsByPage(0, 12);
//        return productsByPage;
//    }
}
