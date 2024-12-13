package carmen.purchasing_agent.core.dto;

import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Product;

public class OrdersDTO {

    private Boolean paid;
    private String takeMethod;
    private String paymentMethod;
    private String remark;
    private Product product;
    private Customer customer;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
