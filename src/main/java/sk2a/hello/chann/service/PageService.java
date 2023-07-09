package sk2a.hello.chann.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk2a.hello.chann.dao.ProductDao;
import sk2a.hello.chann.dao.ProductDao;
import sk2a.hello.chann.pagination.Product;
import sk2a.hello.chann.pagination.Page;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageService {
    private final ProductDao productDao;

    public Page<Product> getProductByPage(int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        List<Product> data = productDao.getProductsByPage(startRow, pageSize);
        long totalItems = productDao.getTotalProductCount();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Page<Product> result = new Page<>();
        result.setData(data);
        result.setCurrentPage(page);
        result.setTotalPages(totalPages);
        result.setPageSize(pageSize);
        result.setTotalItems(totalItems);

        return result;
    }
}
