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

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductDao productDao;
    private final PageService pageService;

    @ResponseBody
    @GetMapping("/product/list")
    public List<Product> getAllProducts(Model model){
        log.info("product list");
        List<Product> product = productDao.getAllProducts();
        return product;
    }

    @ResponseBody
    @PostMapping("/product/search")
    public List<Product> getProductsBySearch(@RequestParam String search){
        log.info("product search={}", search);
        List<Product> product = productDao.getProductsBySearch(search);
        return product;
    }



    @GetMapping("/product/{page}")
    public String showProductList(Model model, @PathVariable int page) {
        log.info("page={}", page);
        int pageSize = 12;
        Page<Product> productPage = pageService.getProductByPage(page, pageSize);

        model.addAttribute("productPage", productPage);
        return "product_list";
    }

    @ResponseBody
    @GetMapping("/api/product/{page}")
    public Page<Product> getProductByPage(@PathVariable int page) {
        int pageSize = 12;
        return pageService.getProductByPage(page, pageSize);
    }
    
}
