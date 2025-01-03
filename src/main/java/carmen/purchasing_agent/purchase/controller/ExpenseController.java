package carmen.purchasing_agent.purchase.controller;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import carmen.purchasing_agent.core.dto.ExpenseDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Expense;
import carmen.purchasing_agent.core.entity.Orders;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.ExpenseService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
@CrossOrigin
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @GetMapping("/getAllExpense")
    public ResultVO getAllExpense(){
        try {
            List<Expense> expenseList = expenseService.getAllExpense();

            if (ObjectUtils.isEmpty(expenseList)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功", expenseList);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @PostMapping("/createConsumption")
    public ResultVO createConsumption(@RequestBody ExpenseDTO expenseDTO){
        try {

            String errMsg = expenseService.createConsumption(expenseDTO);

            return ResultVoUtil.success("成功");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @PostMapping("/modifyConsumption")
    public ResultVO modifyConsumption(@RequestBody ExpenseDTO expenseDTO){
        try {
            String errMsg = expenseService.modifyConsumption(expenseDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功更改");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @DeleteMapping("/deleteExpense/{expenseId}")
    public ResultVO deleteExpense(@PathVariable Integer expenseId){
        try {
            String errMsg = expenseService.deleteExpense(expenseId);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("刪除成功");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


}
