package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByPhone(String phone);

    Customer findByInstagram(String instagram);

    @Query(value = "select * from customer order by MODIFY_DATE DESC", nativeQuery = true)
    List<Customer> findAllOrderDesc();
}
