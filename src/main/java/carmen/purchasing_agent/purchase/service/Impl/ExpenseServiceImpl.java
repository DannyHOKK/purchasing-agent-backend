package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.ExpenseDTO;
import carmen.purchasing_agent.core.entity.Expense;
import carmen.purchasing_agent.purchase.repository.ExpenseRepository;
import carmen.purchasing_agent.purchase.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Override
    public String createConsumption(ExpenseDTO expenseDTO) {

        try {
            Expense expense = new Expense(expenseDTO);
            expense.setCreateDate(new Date());
            expense.setModifyDate(new Date());

            expenseRepository.save(expense);

            return null;
        }catch (Exception e){
            return "保存失敗";
        }
    }

    @Override
    public String modifyConsumption(ExpenseDTO expenseDTO) {
        try {
            Expense expense = expenseRepository.findById(expenseDTO.getExpenseId()).orElseThrow();

            expense.setConsumeCost(expenseDTO.getConsumeCost());
            expense.setPayment(expenseDTO.getPayment());
            expense.setShopName(expenseDTO.getShopName());
            expense.setConsumeType(expenseDTO.getConsumeType());
            expense.setModifyDate(new Date());

            expenseRepository.save(expense);

            return null;
        }catch (Exception e){
            return "更改失敗";
        }
    }

    @Override
    public String deleteExpense(Integer expenseId) {
        try {
            expenseRepository.deleteById(expenseId);
            return null;
        }catch (Exception e){
            return "刪除失敗";
        }
    }

    @Override
    public List<Expense> getAllExpense() {
        try {
            List<Expense> expenseList =  expenseRepository.findAll();
            return expenseList;
        }catch (Exception e){
            return null;
        }
    }

}
