package sk2a.hello.chann.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import sk2a.hello.chann.pagination.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
    private final SqlSession sqlSession;
    private final static String namespace = "sk2a.hello.chann.dao.ProductDao.";

//    @Override
//    public List<Product> getAllProducts() {
//        return sqlSession.selectList(namespace + "getAllProducts");
//    }
//
//    @Override
//    public List<Product> getProductsBySearch(String search) {
//        return sqlSession.selectList(namespace + "getProductsBySearch", search);
//    }

    @Override
    public List<Product> getProductsByPage(int startRow, int pageSize, String search, String category, String price, String time) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRow", startRow);
        params.put("pageSize", pageSize);
        params.put("search", search);
        params.put("category", category);
        params.put("price", price);
        params.put("time", time);
        return sqlSession.selectList(namespace + "getProductsByPage", params);
    }

    @Override
    public long getTotalProductCount(String search, String category, String price, String time) {
        Map<String, Object> params = new HashMap<>();
        params.put("search", search);
        params.put("category", category);
        params.put("price", price);
        params.put("time", time);
        return sqlSession.selectOne(namespace + "getTotalProductCount", params);
    }
}
