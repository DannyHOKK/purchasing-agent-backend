package carmen.purchasing_agent.core.dto;

import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Product;

public class OrdersDTO {

    private Boolean paid;
    private String takeMethod;
    private String paymentMethod;
    private Integer quantity;
    private String remark;
    private Integer productId;
    private Integer customerId;
//    private Product product;
//    private Customer customer;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getTakeMethod() {
        return takeMethod;
    }

    public void setTakeMethod(String takeMethod) {
        this.takeMethod = takeMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
