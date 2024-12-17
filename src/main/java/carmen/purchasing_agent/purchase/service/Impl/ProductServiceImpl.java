package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.purchase.service.ProductService;
import carmen.purchasing_agent.purchase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public String createProduct(ProductDTO productDTO) {

        Product product = new Product(productDTO);

        product.setQuantity(0);
        product.setStock(0);
        product.setCreateDate(new Date());
        product.setModifyDate(new Date());

        productRepository.save(product);

        return null;
    }

    @Override
    public String modifyProduct(ProductDTO productDTO) {

        Product product = productRepository.findById(productDTO.getProductId()).orElseThrow();

        product.setProductBrand(productDTO.getProductBrand());
        product.setProductType(productDTO.getProductType());
        product.setProductName(productDTO.getProductName());
        product.setProductCost(productDTO.getProductCost());
        product.setProductPrice(productDTO.getProductPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setModifyDate(new Date());

        productRepository.save(product);
        return null;
    }

    @Override
    public String deleteProductById(Integer productId) {

        productRepository.deleteById(productId);
        return null;
    }

    @Override
    public Product getProduct(Integer productId) {

        return productRepository.findById(productId).orElseThrow();

    }

    @Override
    public List<Product> getAllProductList() {

        return productRepository.findAll();
    }
}
