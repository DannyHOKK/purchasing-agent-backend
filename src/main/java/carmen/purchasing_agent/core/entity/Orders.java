package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    private Integer quantity;
    private String paid;
    private String orderPlatform;
    private Date createDate;
    private Date modifyDate;
    private String takeMethod;
    private String paymentMethod;
    private String remark;
    private String status;
    private String packageName;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;


    public Orders() {
    }

    public Orders(OrdersDTO ordersDTO) {
        this.paid = ordersDTO.getPaid();
        this.takeMethod = ordersDTO.getTakeMethod();
        this.paymentMethod = ordersDTO.getPaymentMethod();
        this.remark = ordersDTO.getRemark();
        this.quantity = ordersDTO.getQuantity();
    }

    public Orders(Integer orderId, Integer quantity, String paid, Date createDate, Date modifyDate, String takeMethod, String paymentMethod, String remark, String status, Product product, Customer customer) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.paid = paid;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.takeMethod = takeMethod;
        this.paymentMethod = paymentMethod;
        this.remark = remark;
        this.status = status;
        this.product = product;
        this.customer = customer;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getOrderPlatform() {
        return orderPlatform;
    }

    public void setOrderPlatform(String orderPlatform) {
        this.orderPlatform = orderPlatform;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
