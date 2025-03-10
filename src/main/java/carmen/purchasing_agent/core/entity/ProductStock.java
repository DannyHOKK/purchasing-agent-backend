package carmen.purchasing_agent.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "product_stock",
        uniqueConstraints = @UniqueConstraint(columnNames = {"PRODUCT_ID", "PACKAGE_NAME"}))
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",referencedColumnName = "PRODUCT_ID")
    private Product product;
    private Integer stock;
    @Column(name = "PACKAGE_NAME")
    private String packageName;

    public ProductStock() {
    }

    public ProductStock(Integer stockId, Product product, Integer stock, String packageName) {
        this.stockId = stockId;
        this.product = product;
        this.stock = stock;
        this.packageName = packageName;
    }

}
