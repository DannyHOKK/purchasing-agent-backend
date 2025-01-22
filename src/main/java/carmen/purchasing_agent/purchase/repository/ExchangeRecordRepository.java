package carmen.purchasing_agent.purchase.repository;

import carmen.purchasing_agent.core.entity.ExchangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRecordRepository extends JpaRepository<ExchangeRecord, Integer> {
    @Query(value = "SELECT * FROM purchasing_agent.exchange_record order by create_date desc;", nativeQuery = true)
    List<ExchangeRecord> findAllOrderDesc();
}
