package carmen.purchasing_agent.core.dto;

public class ExchangeRateDTO {
    private String currency;
    private Integer exchangeRate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
