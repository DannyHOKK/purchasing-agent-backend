package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Object> findByPhone(String phone);
}
