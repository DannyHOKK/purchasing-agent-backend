package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ExpenseDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EXPENSE")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;
    private String shopName;
    private String consumeType;
    private Integer consumeCost;
    @ManyToOne
    @JoinColumn(name = "CURRENCY", referencedColumnName = "CURRENCY")
    private ExchangeRate exchangeRate;
    private String payment;
    private LocalDate payDate;
    private Date createDate;
    private Date modifyDate;

    public Expense() {
    }

    public Expense(Integer expenseId, String shopName, String consumeType, Integer consumeCost, ExchangeRate exchangeRate, String payment, LocalDate payDate, Date createDate, Date modifyDate) {
        this.expenseId = expenseId;
        this.shopName = shopName;
        this.consumeType = consumeType;
        this.consumeCost = consumeCost;
        this.exchangeRate = exchangeRate;
        this.payment = payment;
        this.payDate = payDate;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public Expense(ExpenseDTO expenseDTO) {
        this.consumeType = expenseDTO.getConsumeType();
        this.consumeCost = expenseDTO.getConsumeCost();
        this.payment = expenseDTO.getPayment();
        this.shopName = expenseDTO.getShopName();
        this.payDate = expenseDTO.getPayDate();
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
