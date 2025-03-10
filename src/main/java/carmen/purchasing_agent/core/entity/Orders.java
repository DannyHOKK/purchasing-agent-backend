package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
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
    private Integer discount;
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
        this.discount = ordersDTO.getDiscount();
        this.packageName = ordersDTO.getPackageName();
        this.orderPlatform = ordersDTO.getOrderPlatform();
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

}
