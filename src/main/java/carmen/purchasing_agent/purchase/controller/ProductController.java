package carmen.purchasing_agent.purchase.controller;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.ProductService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/getProduct")
    public ResultVO getProduct(@RequestParam("productId") Integer productId){
        try {
            Product product = productService.getProduct(productId);

            if (ObjectUtils.isEmpty(product)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功", product);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @GetMapping("/getAllProduct")
    public ResultVO getAllProductList(){
        try {
           List<Product> product = productService.getAllProductList();

            if (ObjectUtils.isEmpty(product)){
                return ResultVoUtil.error("失敗");
            }
            return ResultVoUtil.success("成功", product);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @PostMapping("/createProduct")
    public ResultVO createProduct(@RequestBody ProductDTO productDTO){
        try {
            String errMsg = productService.createProduct(productDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error("保存失敗");
            }
            return ResultVoUtil.success("成功保存");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
    @PostMapping("/modifyProduct")
    public ResultVO modifyProduct(@RequestBody ProductDTO productDTO){
        try {
            String errMsg = productService.modifyProduct(productDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error("更改失敗");
            }
            return ResultVoUtil.success("成功更改");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @DeleteMapping("/deleteProductById/{productId}")
    public ResultVO deleteProductById(@PathVariable Integer productId){
        try {
            String errMsg = productService.deleteProductById(productId);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error("刪除失敗");
            }
            return ResultVoUtil.success("成功刪除");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
}
