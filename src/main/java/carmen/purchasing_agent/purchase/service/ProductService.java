package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.entity.Product;

import java.util.List;

public interface ProductService {
    String createProduct(ProductDTO productDTO);

    String modifyProduct(ProductDTO productDTO);

    String deleteProductById(Integer productId);

    Product getProduct(Integer productId);

    List<Product> getAllProductList();
}
