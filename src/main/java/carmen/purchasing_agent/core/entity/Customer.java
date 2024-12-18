package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
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
}
