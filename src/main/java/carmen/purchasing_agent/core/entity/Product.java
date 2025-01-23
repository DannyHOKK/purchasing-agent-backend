package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @ManyToOne
    @JoinColumn(name = "CURRENCY", referencedColumnName = "CURRENCY")
    private ExchangeRate exchangeRate;
    @Column(name = "PRODUCT_BRAND")
    private String productBrand;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_TYPE")
    private String productType;
    @Column(name = "PRODUCT_COST")
    private String productCost;
    @Column(name = "DISCOUNT")
    private Float discount;
    @Column(name = "PRODUCT_PRICE")
    private Integer productPrice;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "STOCK")
    private Integer stock;
    @Column(name = "COMMISSION")
    private Boolean commission;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    public Product() {
    }

    public Product(ProductDTO productDTO) {
        this.productBrand = productDTO.getProductBrand();
        this.productName = productDTO.getProductName();
        this.productType = productDTO.getProductType();
        this.productCost = productDTO.getProductCost();
        this.productPrice = productDTO.getProductPrice();
        this.commission = productDTO.getCommission();
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Boolean getCommission() {
        return commission;
    }

    public void setCommission(Boolean commission) {
        this.commission = commission;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
