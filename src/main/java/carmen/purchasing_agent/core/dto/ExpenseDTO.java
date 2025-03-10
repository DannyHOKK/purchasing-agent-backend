package carmen.purchasing_agent.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ExpenseDTO {

    private Integer expenseId;
    private String shopName;
    private String consumeType;
    private Integer consumeCost;
    private String currency;
    private String payment;
    private LocalDate payDate;

}
