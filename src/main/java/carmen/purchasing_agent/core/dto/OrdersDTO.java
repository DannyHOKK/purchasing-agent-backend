package carmen.purchasing_agent.core.dto;

import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Product;

public class OrdersDTO {
    private Integer orderId;
    private String phone;
    private String instagram;
    private Boolean paid;
    private String takeMethod;
    private String paymentMethod;
    private Integer quantity;
    private String remark;
    private String productName;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

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

}
