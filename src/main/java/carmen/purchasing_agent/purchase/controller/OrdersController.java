package carmen.purchasing_agent.purchase.controller;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Orders;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.OrdersService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/getAllOrders")
    public ResultVO getAllOrders(){
        try {
            List<Orders> ordersList = ordersService.getAllOrders();

            if (ObjectUtils.isEmpty(ordersList)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功",ordersList);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
    @PostMapping("/createOrder")
    public ResultVO createOrder(@RequestBody OrdersDTO ordersDTO){
        try {
            String errMsg = ordersService.createOrder(ordersDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error("保存失敗");
            }
            return ResultVoUtil.success("成功保存");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @DeleteMapping("/deleteOrderById/{orderId}")
    public ResultVO deleteOrderById(@PathVariable Integer orderId){
        try {
            String errMsg = ordersService.deleteOrderById(orderId);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功刪除");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @PostMapping("/changeStatusOrder")
    public ResultVO changeStatusOrder(@RequestBody OrdersDTO ordersDTO){
        try {
            String errMsg = ordersService.changeStatusOrder(ordersDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功更改");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


    @PostMapping("/modifyOrder")
    public ResultVO modifyOrder(@RequestBody OrdersDTO ordersDTO){
        try {
            String errMsg = ordersService.modifyOrder(ordersDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功更改");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

}
