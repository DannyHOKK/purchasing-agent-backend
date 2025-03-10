package carmen.purchasing_agent.core.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeRateDTO {
    private String currency;
    private Double exchangeRate;

}
