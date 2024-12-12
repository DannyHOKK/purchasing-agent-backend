package carmen.purchasing_agent.product.service.Impl;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.product.service.ProductService;
import carmen.purchasing_agent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public String createProduct(ProductDTO productDTO) {

        Product product = new Product(productDTO);

        product.setCreateDate(new Date());
        product.setModifyDate(new Date());

        productRepository.save(product);

        return "成功保存";
    }
}
