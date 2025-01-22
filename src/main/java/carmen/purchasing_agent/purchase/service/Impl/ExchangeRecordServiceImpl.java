package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.dto.ExchangeRecordDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;
import carmen.purchasing_agent.core.entity.ExchangeRecord;
import carmen.purchasing_agent.purchase.repository.ExchangeRecordRepository;
import carmen.purchasing_agent.purchase.service.ExchangeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExchangeRecordServiceImpl implements ExchangeRecordService {

    @Autowired
    private ExchangeRecordRepository exchangeRecordRepository;
    @Override
    public String createExchangeRecord(ExchangeRecordDTO exchangeRecordDTO) {
        try {
            ExchangeRecord exchangeRecord = new ExchangeRecord(exchangeRecordDTO);
            exchangeRecord.setCreateDate(new Date());
            exchangeRecordRepository.save(exchangeRecord);
            return null;

        }catch (Exception e){
            return "保存失敗";
        }
    }

    @Override
    public List<ExchangeRecord> getAllExchangeRecord() {
        try {
            List<ExchangeRecord> exchangeRecordList = exchangeRecordRepository.findAllOrderDesc();
            return exchangeRecordList;

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String deleteExchangeRecord(Integer exchangeId) {
        try {
            exchangeRecordRepository.deleteById(exchangeId);
            return null;

        }catch (Exception e){
            return "刪除失敗";
        }
    }
}
