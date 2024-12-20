package carmen.purchasing_agent.purchase.controller;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.CustomerService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("getAllCustomer")
    public ResultVO getAllCustomer(){
        try {
            List<Customer> customerList = customerService.getAllCustomer();

            if (ObjectUtils.isEmpty(customerList)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功", customerList);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
    @GetMapping("/getCustomerById")
    public ResultVO getCustomerById(@RequestParam("customerId") Integer customerId){
        try {
            Customer customer = customerService.getCustomerById(customerId);

            if (ObjectUtils.isEmpty(customer)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功",customer);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @GetMapping("/getCustomerByPhone")
    public ResultVO getCustomerByPhone(@RequestParam("phone") String phone){
        try {
            Customer customer = customerService.getCustomerByPhone(phone);

            if (ObjectUtils.isEmpty(customer)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功",customer);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @PostMapping("/createCustomer")
    public ResultVO createCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            String errMsg = customerService.createCustomer(customerDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功保存");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResultVO deleteCustomer(@PathVariable Integer customerId){
        try {
            String errMsg = customerService.deleteCustomer(customerId);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("刪除成功");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @PostMapping("/modifyCustomer")
    public ResultVO modifyCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            String errMsg = customerService.modifyCustomer(customerDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功更改");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @PostMapping("/checkCustomerExist")
    public ResultVO checkCustomerExist(@RequestBody CustomerDTO customerDTO){
        try {
            String errMsg = customerService.checkCustomerExist(customerDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

}
