package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {
    @Query(value = "Select * from product_stock where PACKAGE_NAME = :packageName and PRODUCT_ID = :productId", nativeQuery = true)
    ProductStock checkProductStockExist(String packageName, Integer productId);

    @Query(value = "Select * from product_stock where PACKAGE_NAME = :packageName", nativeQuery = true)
    List<ProductStock> getAllProductStockByPackageName(String packageName);
}
