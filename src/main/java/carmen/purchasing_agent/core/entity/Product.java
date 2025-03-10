package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
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
    @Column(name = "WEIGHT")
    private Double weight;
    @Column(name = "DISCOUNT")
    private Float discount;
    @Column(name = "PRODUCT_PRICE")
    private Integer productPrice;
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
        this.productType = productDTO.getProductType();
        this.productCost = productDTO.getProductCost();
        this.productPrice = productDTO.getProductPrice();
        this.commission = productDTO.getCommission();
        this.weight = productDTO.getWeight();
    }

}
