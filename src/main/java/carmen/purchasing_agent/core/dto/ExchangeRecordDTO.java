package carmen.purchasing_agent.core.dto;

import java.time.LocalDate;

public class ExchangeRecordDTO {
    private String currency;
    private Integer exchangeCost;
    private Double exchangeRate;
    private LocalDate exchangeDate;

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

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public LocalDate getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }
}
