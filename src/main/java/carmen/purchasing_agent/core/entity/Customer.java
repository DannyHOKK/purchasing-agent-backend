package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "INSTAGRAM")
    private String instagram;
    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
    @Column(name = "REMARK")
    private String remark;

    public Customer() {
    }

    public Customer(CustomerDTO customerDTO) {
        this.phone = customerDTO.getPhone();
        this.instagram = customerDTO.getInstagram();
        this.shippingAddress = customerDTO.getShippingAddress();
        this.remark = customerDTO.getRemark();
    }



    public Customer(Integer customerId, String phone, String instagram, String shippingAddress, Date createDate, Date modifyDate, String remark) {
        this.customerId = customerId;
        this.phone = phone;
        this.instagram = instagram;
        this.shippingAddress = shippingAddress;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.remark = remark;
    }

}
