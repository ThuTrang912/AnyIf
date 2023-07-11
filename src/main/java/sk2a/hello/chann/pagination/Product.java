package sk2a.hello.chann.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer imageId;
    private String serverFileName;
    private String productName;
    private String productDetail;
    private BigDecimal productCost;
    private Integer likeId;
    // Các thuộc tính khác của sản phẩm
}
