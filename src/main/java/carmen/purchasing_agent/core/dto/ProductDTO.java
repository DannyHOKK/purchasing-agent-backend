package carmen.purchasing_agent.core.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Setter
@Getter
public class ProductDTO {
    private Integer productId;
    private String currency;
    private String productBrand;
    private String productName;
    private String productType;
    private String productCost;
    private Double weight;
    private Float discount;
    private Integer productPrice;
    private Integer stock;
    private Boolean commission;
    private List<String> productColor;
    private String packageName;


}
