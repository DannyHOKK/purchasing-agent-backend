package carmen.purchasing_agent.core.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDTO {
    private Integer customerId;
    private String phone;
    private String instagram;
    private String shippingAddress;
    private String remark;

}
