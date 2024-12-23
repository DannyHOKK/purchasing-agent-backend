package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateService {
    String createCurrency(ExchangeRateDTO exchangeRateDTO);

    List<ExchangeRate> getExchangeRate();
}
