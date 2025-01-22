package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "Select * from orders order by CREATE_DATE DESC", nativeQuery = true)
    List<Orders> findAllDescOrder();
}
