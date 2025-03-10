package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.dto.ExchangeRecordDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "EXCHANGE_RECORD")
public class ExchangeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exchangeId;
    private String currency;
    private Integer exchangeCost;
    private Double exchangeRate;
    private LocalDate exchangeDate;
    private Date createDate;

    public ExchangeRecord() {
    }

    public ExchangeRecord(ExchangeRecordDTO exchangeRecordDTO) {
        this.currency = exchangeRecordDTO.getCurrency();
        this.exchangeCost = exchangeRecordDTO.getExchangeCost();
        this.exchangeRate = exchangeRecordDTO.getExchangeRate();
        this.exchangeDate = exchangeRecordDTO.getExchangeDate();
    }

    public ExchangeRecord(Integer exchangeId, String currency, Integer exchangeCost, Double exchangeRate, LocalDate exchangeDate, Date createDate) {
        this.exchangeId = exchangeId;
        this.currency = currency;
        this.exchangeCost = exchangeCost;
        this.exchangeRate = exchangeRate;
        this.exchangeDate = exchangeDate;
        this.createDate = createDate;
    }

}
