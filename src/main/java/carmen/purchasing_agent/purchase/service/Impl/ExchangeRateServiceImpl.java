package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;
import carmen.purchasing_agent.purchase.repository.ExchangeRateRepository;
import carmen.purchasing_agent.purchase.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public String createCurrency(ExchangeRateDTO exchangeRateDTO) {

        try {
            ExchangeRate exchangeRate = new ExchangeRate(exchangeRateDTO);
            exchangeRate.setCreateDate(new Date());
            exchangeRate.setModifyDate(new Date());

            exchangeRateRepository.save(exchangeRate);

            return null;

        }catch (Exception e){
            return "創立失敗";
        }

    }

    @Override
    public List<ExchangeRate> getExchangeRate() {
        try {
            List<ExchangeRate> exchangeRateList = exchangeRateRepository.findAll();
            return exchangeRateList;

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String deleteExchange(String currency) {
        try {
            exchangeRateRepository.deleteById(currency);
            return null;

        }catch (Exception e){
            return "刪除失敗";
        }
    }
}
