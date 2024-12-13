package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    private Boolean paid;
    private Date createDate;
    private Date modifyDate;
    private String takeMethod;
    private String paymentMethod;
    private String remark;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;


    public Orders(OrdersDTO ordersDTO) {
        this.paid = ordersDTO.getPaid();
        this.takeMethod = ordersDTO.getTakeMethod();
        this.paymentMethod = ordersDTO.getPaymentMethod();
        this.remark = ordersDTO.getRemark();
        this.product = ordersDTO.getProduct();
        this.customer = ordersDTO.getCustomer();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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
