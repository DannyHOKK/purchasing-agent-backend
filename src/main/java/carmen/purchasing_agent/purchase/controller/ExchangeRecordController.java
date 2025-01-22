package carmen.purchasing_agent.purchase.controller;


import carmen.purchasing_agent.core.dto.ExchangeRateDTO;
import carmen.purchasing_agent.core.dto.ExchangeRecordDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;
import carmen.purchasing_agent.core.entity.ExchangeRecord;
import carmen.purchasing_agent.core.util.ResultVoUtil;
import carmen.purchasing_agent.core.vo.ResultVO;
import carmen.purchasing_agent.purchase.service.ExchangeRecordService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchangeRecord")
@CrossOrigin
public class ExchangeRecordController {


    @Autowired
    private ExchangeRecordService exchangeRecordService;

    @PostMapping("/createExchangeRecord")
    public ResultVO createExchangeRecord(@RequestBody ExchangeRecordDTO exchangeRecordDTO){
        try {
            String errMsg = exchangeRecordService.createExchangeRecord(exchangeRecordDTO);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功保存");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @GetMapping("/getAllExchangeRecord")
    public ResultVO getAllExchangeRecord(){
        try {
            List<ExchangeRecord> exchangeRecordList= exchangeRecordService.getAllExchangeRecord();

            if (ObjectUtils.isEmpty(exchangeRecordList)){
                return ResultVoUtil.error("讀取失敗");
            }
            return ResultVoUtil.success("成功讀取", exchangeRecordList);
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @DeleteMapping("/deleteExchangeRecord/{exchangeId}")
    public ResultVO deleteExchangeRecord(@PathVariable Integer exchangeId){
        try {
            String errMsg = exchangeRecordService.deleteExchangeRecord(exchangeId);

            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("刪除成功");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }


}
