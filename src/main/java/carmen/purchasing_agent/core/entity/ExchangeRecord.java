package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.dto.ExchangeRecordDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EXCHANGE_RECORD")
public class ExchangeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exchangeId;
    private String currency;
    private Integer exchangeCost;
    private Integer exchangeRate;
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

    public ExchangeRecord(Integer exchangeId, String currency, Integer exchangeCost, Integer exchangeRate, LocalDate exchangeDate, Date createDate) {
        this.exchangeId = exchangeId;
        this.currency = currency;
        this.exchangeCost = exchangeCost;
        this.exchangeRate = exchangeRate;
        this.exchangeDate = exchangeDate;
        this.createDate = createDate;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getExchangeCost() {
        return exchangeCost;
    }

    public void setExchangeCost(Integer exchangeCost) {
        this.exchangeCost = exchangeCost;
    }

    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public LocalDate getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
