package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.ProductDTO;
import carmen.purchasing_agent.core.entity.ExchangeRate;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.core.entity.ProductStock;
import carmen.purchasing_agent.purchase.repository.ExchangeRateRepository;
import carmen.purchasing_agent.purchase.repository.ProductStockRepository;
import carmen.purchasing_agent.purchase.service.ProductService;
import carmen.purchasing_agent.purchase.repository.ProductRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private ProductStockRepository productStockRepository;

    @Override
    @Transactional
    public String createProduct(ProductDTO productDTO) {




        ExchangeRate exchangeRate = exchangeRateRepository.getReferenceById(productDTO.getCurrency());

        if (productDTO.getProductColor() == null || productDTO.getProductColor().isEmpty()){

            Product checkProduct = productRepository.findByProductName(productDTO.getProductName());
            if (ObjectUtils.isNotEmpty(checkProduct)){
                return "貸品名稱重複";
            }


            Product product = new Product(productDTO);

            product.setProductName(productDTO.getProductName());
            product.setExchangeRate(exchangeRate);
            product.setDiscount(productDTO.getDiscount());
            product.setStock(productDTO.getStock());
            product.setCreateDate(new Date());
            product.setModifyDate(new Date());

            productRepository.save(product);
            createProductStock(product,productDTO);
        }else{
            for (int i = 0 ; i < productDTO.getProductColor().size(); i++){

                Product checkProduct = productRepository.findByProductName(productDTO.getProductName() + " | " + productDTO.getProductColor().get(i));
                if (ObjectUtils.isNotEmpty(checkProduct)){
                    return "貸品名稱重複";
                }

                Product product = new Product(productDTO);

                product.setProductName(productDTO.getProductName() + " | " + productDTO.getProductColor().get(i));
                product.setExchangeRate(exchangeRate);
                product.setDiscount(productDTO.getDiscount());
//                product.setStock(productDTO.getStock());
                product.setCreateDate(new Date());
                product.setModifyDate(new Date());

                productRepository.save(product);
                createProductStock(product,productDTO);
            }
        }

        return null;
    }

    public void createProductStock(Product product, ProductDTO productDTO){
        try {
            ProductStock productStock = new ProductStock();
            productStock.setProduct(product);
            productStock.setStock(product.getStock());
            productStock.setPackageName(productDTO.getPackageName());

            productStockRepository.save(productStock);
        }catch (Exception e){
            return;
        }
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
        product.setDiscount(productDTO.getDiscount());
        product.setModifyDate(new Date());


        ProductStock checkProductStockExist = productStockRepository.checkProductStockExist(productDTO.getPackageName(), productDTO.getProductId());

        if(ObjectUtils.isEmpty(checkProductStockExist)){
            ProductStock productStock = new ProductStock();

            productStock.setPackageName(productDTO.getPackageName());
            productStock.setProduct(product);
            productStock.setStock(productDTO.getStock());

            productStockRepository.save(productStock);
        }else{
            checkProductStockExist.setStock(productDTO.getStock());
            productStockRepository.save(checkProductStockExist);
        }
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

        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "productBrand"));
    }
}
