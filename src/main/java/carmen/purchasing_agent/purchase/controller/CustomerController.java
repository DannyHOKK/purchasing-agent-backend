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

@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomerById")
    public ResultVO getCustomer(@RequestParam("customerId") Integer customerId){
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
    public ResultVO getCustomer(@RequestParam("customerPhone") String phone){
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
                return ResultVoUtil.error("保存失敗");
            }
            return ResultVoUtil.success("成功保存");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


}
