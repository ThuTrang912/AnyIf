package sk2a.hello.chann.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String serverFileName;
    private String productName;
    private String productDetail;
    private double productCost;
    private int likeId;
    // Các thuộc tính khác của sản phẩm
}
