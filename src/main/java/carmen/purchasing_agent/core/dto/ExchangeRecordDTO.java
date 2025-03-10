package carmen.purchasing_agent.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ExchangeRecordDTO {
    private String currency;
    private Integer exchangeCost;
    private Double exchangeRate;
    private LocalDate exchangeDate;

}
