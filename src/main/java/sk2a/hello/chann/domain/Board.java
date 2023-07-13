package sk2a.hello.chann.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private String serverFileName;
    private String productName;
    private String productDetail;
    private BigDecimal productCost;
    private Integer likeId;
    private Date regDate;
}
