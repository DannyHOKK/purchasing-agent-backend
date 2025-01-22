package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.ExchangeRecordDTO;
import carmen.purchasing_agent.core.entity.ExchangeRecord;

import java.util.List;

public interface ExchangeRecordService {
    String createExchangeRecord(ExchangeRecordDTO exchangeRecordDTO);

    List<ExchangeRecord> getAllExchangeRecord();

    String deleteExchangeRecord(Integer exchangeId);
}
