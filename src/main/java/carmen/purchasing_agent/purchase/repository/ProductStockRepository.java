package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {
    @Query(value = "Select * from product_stock where PACKAGE_NAME = :packageName and PRODUCT_ID = :productId", nativeQuery = true)
    ProductStock checkProductStockExist(String packageName, Integer productId);

    @Query(value = "Select * from product_stock where PACKAGE_NAME = :packageName", nativeQuery = true)
    List<ProductStock> getAllProductStockByPackageName(String packageName);

    @Query(value = "Select * from product_stock where PRODUCT_ID = :productId", nativeQuery = true)
    List<ProductStock> findAllByProductId(@Param("productId") Integer productId);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO product_stock (PRODUCT_ID, PACKAGE_NAME, stock) " +
            "VALUES (:productId, :packageName, :stock) " +
            "ON DUPLICATE KEY UPDATE stock = :stock", nativeQuery = true)
    void upsertProductStock(@Param("productId") Integer productId,
                            @Param("packageName") String packageName,
                            @Param("stock") Integer stock);

    @Query(value = "Select * from product_stock where PACKAGE_NAME = :packageName and IN (:orderIdList)", nativeQuery = true)
    List<ProductStock> getAllProductStockByPackageNameAndOrderId(@Param("packageName") String packageName,
                                                                 @Param("orderIdList") List<Integer> orderIdList);

    @Query(value = "Select * from product_stock where PACKAGE_NAME = :packageName and PRODUCT_ID IN (:productIdList)", nativeQuery = true)
    List<ProductStock> getAllProductStockByPackageNameAndProductId(@Param("packageName")String packagingToGoName,
                                                                   @Param("productIdList")List<Integer> productIdList);
}
