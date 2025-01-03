package carmen.purchasing_agent.core.dto;

public class ExpenseDTO {

    private Integer expenseId;
    private String shopName;
    private String consumeType;
    private Integer consumeCost;
    private String payment;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType;
    }

    public Integer getConsumeCost() {
        return consumeCost;
    }

    public void setConsumeCost(Integer consumeCost) {
        this.consumeCost = consumeCost;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
