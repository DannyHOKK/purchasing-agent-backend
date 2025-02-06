package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
