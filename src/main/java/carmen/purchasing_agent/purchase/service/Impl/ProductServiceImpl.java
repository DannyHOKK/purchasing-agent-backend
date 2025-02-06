package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.purchase.repository.ExchangeRateRepository;
import carmen.purchasing_agent.purchase.service.ProductService;
import carmen.purchasing_agent.purchase.repository.ProductRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public String createProduct(ProductDTO productDTO) {

        Product product = new Product(productDTO);

        Product checkProduct = productRepository.findByProductName(productDTO.getProductName());
        if (ObjectUtils.isNotEmpty(checkProduct)){
            return "貸品名稱重複";
        }

        ExchangeRate exchangeRate = exchangeRateRepository.getReferenceById(productDTO.getCurrency());

        product.setQuantity(0);
        product.setExchangeRate(exchangeRate);
        product.setDiscount(productDTO.getDiscount());
        product.setStock(productDTO.getStock());
        product.setCreateDate(new Date());
        product.setModifyDate(new Date());

        productRepository.save(product);

        return null;
    }

    @Override
    public String modifyProduct(ProductDTO productDTO) {

        Product product = productRepository.findById(productDTO.getProductId()).orElseThrow();

        Product checkProductName = productRepository.findByProductName(productDTO.getProductName());

        if (!StringUtils.equals(product.getProductName(),productDTO.getProductName())){
            if(ObjectUtils.isNotEmpty(checkProductName)){
                return "貸品名稱重複";
            }
        }

        ExchangeRate exchangeRate = exchangeRateRepository.getReferenceById(productDTO.getCurrency());

        product.setExchangeRate(exchangeRate);
        product.setCommission(productDTO.getCommission());
        product.setProductBrand(productDTO.getProductBrand());
        product.setProductType(productDTO.getProductType());
        product.setProductName(productDTO.getProductName());
        product.setProductCost(productDTO.getProductCost());
        product.setWeight(productDTO.getWeight());
        product.setProductPrice(productDTO.getProductPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDiscount(productDTO.getDiscount());
        product.setModifyDate(new Date());
        product.setStock(productDTO.getStock());

        productRepository.save(product);
        return null;
    }

    @Override
    public String deleteProductById(Integer productId) {

        try{
            productRepository.deleteById(productId);
            return null;
        }catch (Exception e){
            return "刪除失敗，貨品已被落單，請先刪除訂單";
        }
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
