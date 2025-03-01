package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
//    @Query(value = "Select * from orders order by CREATE_DATE DESC", nativeQuery = true)
//    List<Orders> findAllDescOrder();

    @Modifying
    @Transactional
    @Query(value = "UPDATE orders o SET o.PACKAGE_NAME = :packageName WHERE o.ORDER_ID IN (:orderIds)", nativeQuery = true)
    void batchUpdatePackageNameByOrderIds(@Param("orderIds") List<String> orderIds,
                                          @Param("packageName") String packageName);

    @Query(value = "Select * from orders WHERE PACKAGE_NAME = :packageName order by CREATE_DATE DESC", nativeQuery = true)
    List<Orders> findAllDescOrderByPackageName(String packageName);
    @Query(value = "SELECT DISTINCT PACKAGE_NAME FROM orders", nativeQuery = true)
    List<String> getPackageName();

    @Query(value = "SELECT * FROM orders WHERE PRODUCT_ID = :productId", nativeQuery = true)
    List<Orders> findByProductId(@Param("productId") Integer productId);
}
