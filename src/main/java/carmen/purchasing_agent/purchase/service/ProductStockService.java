package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.entity.ProductStock;

import java.util.List;

public interface ProductStockService {
    List<ProductStock> getAllProductStockByPackageName(String packageName);
}
