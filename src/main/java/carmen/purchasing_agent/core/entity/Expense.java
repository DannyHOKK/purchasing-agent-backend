package carmen.purchasing_agent.core.entity;

import carmen.purchasing_agent.core.dto.ExpenseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
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

}
