package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.entity.ProductStock;
import carmen.purchasing_agent.purchase.repository.ProductStockRepository;
import carmen.purchasing_agent.purchase.service.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStockServiceImpl implements ProductStockService {

    @Autowired
    private ProductStockRepository productStockRepository;

    @Override
    public List<ProductStock> getAllProductStockByPackageName(String packageName) {

        try {
            return productStockRepository.getAllProductStockByPackageName(packageName);
        }catch (Exception e){
            return null;
        }

    }
}
