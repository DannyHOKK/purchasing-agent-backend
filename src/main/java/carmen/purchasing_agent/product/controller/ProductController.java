package carmen.purchasing_agent.product.controller;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    private ProductService productService;

    @PostMapping("/createProduct")
    public ResultVO createProduct(@RequestBody ProductDTO productDTO){
        try {
            String errMsg = productService.createProduct(productDTO);

            return ResultVoUtil.error();
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
}
