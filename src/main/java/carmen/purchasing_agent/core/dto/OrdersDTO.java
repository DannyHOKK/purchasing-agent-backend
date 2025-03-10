package carmen.purchasing_agent.core.dto;

import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrdersDTO {
    private Integer orderId;
    private String phone;
    private String instagram;
    private String paid;
    private String orderPlatform;
    private String takeMethod;
    private String paymentMethod;
    private Integer quantity;
    private String remark;
    private String productName;
    private String status;
    private String packageName;
    private Integer discount;

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
