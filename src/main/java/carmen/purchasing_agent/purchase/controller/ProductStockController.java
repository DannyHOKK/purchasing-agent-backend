package carmen.purchasing_agent.purchase.controller;

import carmen.purchasing_agent.core.dto.ProductStockDTO;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.core.entity.ProductStock;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.ProductStockService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productStock")
@CrossOrigin
public class ProductStockController {

    @Autowired
    private ProductStockService productStockService;


    @PostMapping("/getAllProductStock")
    public ResultVO getAllProductStock(@RequestParam("packageName") String packageName){
        try {
            List<ProductStock>  productStockList = productStockService.getAllProductStockByPackageName(packageName);

            if (productStockList == null || productStockList.isEmpty()){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success( productStockList);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

}
