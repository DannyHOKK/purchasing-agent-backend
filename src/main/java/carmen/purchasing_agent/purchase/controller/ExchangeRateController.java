package carmen.purchasing_agent.purchase.controller;


import carmen.purchasing_agent.core.dto.CustomerDTO;
import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.ExchangeRateService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchangeRate")
@CrossOrigin
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;
    @PostMapping("/createCurrency")
    public ResultVO createCurrency(@RequestBody ExchangeRateDTO exchangeRateDTO){
        try {
            String errMsg = exchangeRateService.createCurrency(exchangeRateDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功保存");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @GetMapping("/getExchangeRate")
    public ResultVO getExchangeRate(){
        try {
            List<ExchangeRate> exchangeRateList= exchangeRateService.getExchangeRate();

            if (ObjectUtils.isEmpty(exchangeRateList)){
                return ResultVoUtil.error("讀取失敗");
            }
            return ResultVoUtil.success("成功讀取", exchangeRateList);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @DeleteMapping("/deleteExchange/{currency}")
    public ResultVO deleteExchange(@PathVariable String currency){
        try {
            String errMsg = exchangeRateService.deleteExchange(currency);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("刪除成功");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

}
