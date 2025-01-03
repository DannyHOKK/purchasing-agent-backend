package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.ExpenseDTO;
import carmen.purchasing_agent.core.entity.Expense;

import java.util.List;

public interface ExpenseService {
    String createConsumption(ExpenseDTO expenseDTO);

    String modifyConsumption(ExpenseDTO expenseDTO);

    String deleteExpense(Integer expenseId);

    List<Expense> getAllExpense();
}
