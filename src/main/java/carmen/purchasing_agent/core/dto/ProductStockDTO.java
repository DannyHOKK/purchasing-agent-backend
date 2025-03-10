package carmen.purchasing_agent.core.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductStockDTO {

    private String packageName;
    private String productId;
    private Integer stock;

}
