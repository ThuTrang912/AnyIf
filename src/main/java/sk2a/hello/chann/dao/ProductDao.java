package sk2a.hello.chann.dao;

import org.apache.ibatis.annotations.Param;
import sk2a.hello.chann.pagination.Product;
import sk2a.hello.chann.pagination.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    List<Product> getProductsBySearch(String search);
    List<Product> getProductsByPage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);
    long getTotalProductCount();

    
}

