package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "EXCHANGE_RATE")
public class ExchangeRate {
    @Id
    private String currency;
    private Double exchangeRate;
    private Date createDate;
    private Date modifyDate;

    public ExchangeRate() {
    }

    public ExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        this.currency = exchangeRateDTO.getCurrency();
        this.exchangeRate = exchangeRateDTO.getExchangeRate();
    }

}
