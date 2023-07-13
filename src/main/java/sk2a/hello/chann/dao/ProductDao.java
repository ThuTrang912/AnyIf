package sk2a.hello.chann.dao;

import org.apache.ibatis.annotations.Param;
import sk2a.hello.chann.pagination.Product;

import java.util.List;

public interface ProductDao {
//    List<Product> getAllProducts();
//
//    List<Product> getProductsBySearch(@Param("search") String search);

    List<Product> getProductsByPage(
            @Param("startRow") int startRow,
            @Param("pageSize") int pageSize,
            @Param("search") String search,
            @Param("category") String category,
            @Param("price") String price,
            @Param("time") String time
    );

    long getTotalProductCount(
            @Param("search") String search,
            @Param("category") String category,
            @Param("price") String price,
            @Param("time") String time
    );
}
