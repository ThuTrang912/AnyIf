package sk2a.hello.chann.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk2a.hello.chann.dao.ProductDao;
import sk2a.hello.chann.pagination.Page;
import sk2a.hello.chann.pagination.Product;
import sk2a.hello.chann.service.PageService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductDao productDao;
    private final PageService pageService;

//    @GetMapping("/product/{page}")
//    public String showProductList(
//            Model model,
//            @PathVariable int page,
//            @RequestParam(required = false) String search,
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) String price,
//            @RequestParam(required = false) String time
//    ) {
//        log.info("page={}, search={}, category={}, price={}, time={}", page, search, category, price, time);
//        int pageSize = 3;
//        Page<Product> productPage = pageService.getProductByPage(page, pageSize, search, category, price, time);
//
//        model.addAttribute("productPage", productPage);
//        return "product_list"; // Return the name of the Thymeleaf template
//    }

//    @ResponseBody
//    @GetMapping("/api/product/{page}")
//    public Page<Product> getProductByPage(
//            @PathVariable int page,
//            @RequestParam(required = false) String search,
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) String price,
//            @RequestParam(required = false) String time
//    ) {
//        int pageSize = 3;
//        return pageService.getProductByPage(page, pageSize, search, category, price, time);
//    }
}
