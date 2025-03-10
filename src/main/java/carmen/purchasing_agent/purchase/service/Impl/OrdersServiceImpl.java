package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.OrderPackagingDTO;
import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Orders;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.core.entity.ProductStock;
import carmen.purchasing_agent.purchase.repository.CustomerRepository;
import carmen.purchasing_agent.purchase.repository.OrdersRepository;
import carmen.purchasing_agent.purchase.repository.ProductRepository;
import carmen.purchasing_agent.purchase.repository.ProductStockRepository;
import carmen.purchasing_agent.purchase.service.OrdersService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductStockRepository productStockRepository;
    @Override
    @Transactional
    public String createOrder(OrdersDTO ordersDTO) {

        Orders orders = new Orders(ordersDTO);

//        Product product = productRepository.findById(ordersDTO.getProductId()).orElseThrow();
//        Customer customer = customerRepository.findById(ordersDTO.getCustomerId()).orElseThrow();

        Customer customer = new Customer();
        Product product = productRepository.findByProductName(ordersDTO.getProductName());
        if (StringUtils.isNotEmpty(ordersDTO.getPhone())) {
            customer = customerRepository.findByPhone(ordersDTO.getPhone());
        }else if(StringUtils.isNotEmpty(ordersDTO.getInstagram())){
            customer = customerRepository.findByInstagram(ordersDTO.getInstagram());
        }else{
            return "電話 / IG 錯誤";
        }

        orders.setCustomer(customer);
        orders.setProduct(product);
        orders.setCreateDate(new Date());
        orders.setModifyDate(new Date());
        orders.setStatus("備貨中");

        productRepository.save(product);
        ordersRepository.save(orders);

        return null;
    }

    @Override
    public List<Orders> getAllOrders(String packageName) {

        List<Orders> ordersList = ordersRepository.findAllDescOrderByPackageName(packageName);

        return ordersList;
    }

    @Override
    public String deleteOrderById(Integer orderId) {

        try {
            ordersRepository.deleteById(orderId);
            return null;
        }catch (Exception e){
            return "刪除失敗";
        }

    }

    @Override
    public String changeStatusOrder(OrdersDTO ordersDTO) {
        try {
            Orders orders = ordersRepository.findById(ordersDTO.getOrderId()).orElseThrow();

            orders.setModifyDate(new Date());
            orders.setStatus(ordersDTO.getStatus());

            ordersRepository.save(orders);

            return null;

        }catch (Exception e){
            return "更改失敗";
        }
    }

    @Override
    public String modifyOrder(OrdersDTO ordersDTO) {

        try {
            Orders order = ordersRepository.findById(ordersDTO.getOrderId()).orElseThrow();

            Product product = productRepository.findByProductName(ordersDTO.getProductName());

            if (ObjectUtils.isEmpty(order) || ObjectUtils.isEmpty(product))
            {
                return "貨品 / 訂單不正確";
            }
            order.setPaid(ordersDTO.getPaid());
            order.setOrderPlatform(ordersDTO.getOrderPlatform());
            order.setModifyDate(new Date());
            order.setPaid(ordersDTO.getPaid());
            order.setProduct(product);
            order.setQuantity(ordersDTO.getQuantity());
            order.setPaymentMethod(ordersDTO.getPaymentMethod());
            order.setTakeMethod(ordersDTO.getTakeMethod());
            order.setRemark(ordersDTO.getRemark());
            order.setDiscount(ordersDTO.getDiscount());
            ordersRepository.save(order);

            return null;
        }catch (Exception e){
            return "更改失敗";
        }
    }

    @Override
    public String changePaidOrder(OrdersDTO ordersDTO) {
        try {
            Orders orders = ordersRepository.findById(ordersDTO.getOrderId()).orElseThrow();


            if (StringUtils.equals(ordersDTO.getPaid(),"已付款")){
                orders.setCreateDate(new Date());
            }

            orders.setPaid(ordersDTO.getPaid());
            orders.setModifyDate(new Date());

            ordersRepository.save(orders);

            return null;

        }catch (Exception e){
            return "更改失敗";
        }
    }

    @Override
    public String changeTakeMethodOrder(OrdersDTO ordersDTO) {
        try {
            Orders orders = ordersRepository.findById(ordersDTO.getOrderId()).orElseThrow();


            orders.setTakeMethod(ordersDTO.getTakeMethod());
            orders.setModifyDate(new Date());

            ordersRepository.save(orders);

            return null;

        }catch (Exception e){
            return "更改失敗";
        }
    }

    @Override
    public String changePaymentMethod(OrdersDTO ordersDTO) {
        try {
            Orders orders = ordersRepository.findById(ordersDTO.getOrderId()).orElseThrow();


            orders.setPaymentMethod(ordersDTO.getPaymentMethod());

            ordersRepository.save(orders);

            return null;

        }catch (Exception e){
            return "更改失敗";
        }
    }

    @Override
//    @Transactional
    public String batchPackaging(OrderPackagingDTO orderPackagingDTO) {

        try {
            ordersRepository.batchUpdatePackageNameByOrderIds(orderPackagingDTO.getOrderIdList(), orderPackagingDTO.getPackagingToGoName());

            List<Orders> orderList = ordersRepository.findAllById(orderPackagingDTO.getOrderIdList());
//            List<ProductStock> productStockToGOList = productStockRepository.getAllProductStockByPackageName(orderPackagingDTO.getPackagingToGoName());
//            List<ProductStock> productStockList = productStockRepository.getAllProductStockByPackageName(orderPackagingDTO.getPackageName());


            HashMap<Integer, Integer> orderQuantities = new HashMap<>();
            HashMap<Integer, Integer> productToGoStock = new HashMap<>();
            HashMap<Integer, Integer> productStock = new HashMap<>();

            // 第一步：遍歷 orderList，收集 productId 和 quantity
            for (Orders order : orderList) {
                Integer productId = order.getProduct().getProductId();
                orderQuantities.merge(productId, order.getQuantity(), Integer::sum); // 累加相同 productId 的 quantity
                productToGoStock.put(productId, 0);
                productStock.put(productId, 0);
            }
            List<Integer> productIdList = new ArrayList<>(orderQuantities.keySet());

            List<ProductStock> productStockToGOList = productStockRepository.getAllProductStockByPackageNameAndProductId(orderPackagingDTO.getPackagingToGoName(),
                    productIdList);
            List<ProductStock> productStockList = productStockRepository.getAllProductStockByPackageNameAndProductId(orderPackagingDTO.getPackageName(),
                    productIdList);

            for (Map.Entry<Integer, Integer> entry : orderQuantities.entrySet()){
                int productId = entry.getKey();
                ProductStock stocks = productStockList.stream()
                        .filter(stock -> stock.getProduct().getProductId().equals(productId))
                        .findFirst()
                        .orElse(null);
//                assert stocks != null;
                int initialStock = stocks != null ? stocks.getStock() : 0;
                productStock.merge(productId, initialStock - entry.getValue(), Integer::sum);


                ProductStock toGoStocks = productStockToGOList.stream()
                        .filter(stock -> stock.getProduct().getProductId().equals(productId))
                        .findFirst()
                        .orElse(null);
//                assert toGoStocks != null;
                int initialToGOStock = toGoStocks != null ? toGoStocks.getStock() : 0;
                    productToGoStock.merge(productId, initialToGOStock + (Math.min(initialStock - entry.getValue(), 0))
                            + entry.getValue(), Integer::sum);
            }





            // 第二步：遍歷 productStockList，初始化並更新 productStock
//            for (ProductStock stock : productStockList) {
//                Integer productId = stock.getProduct().getProductId();
//                Integer orderQuantity = orderQuantities.get(productId);
//                if (orderQuantity != null) { // 只處理 orderList 中有的 productId
//                    int initialStock = stock.getStock();
//                    productStock.merge(productId, initialStock - orderQuantity, Integer::sum);
//
//                }
//            }

            // 第三步：遍歷 productStockToGoList，初始化並更新 productToGoStock
//            for (ProductStock toGoStock : productStockToGOList) {
//                Integer productId = toGoStock.getProduct().getProductId();
//                Integer orderQuantity = orderQuantities.get(productId);
//                if (orderQuantity != null) {
//                    int initialStock = toGoStock.getStock();
//                    productToGoStock.merge(productId, initialStock + (productStock.get(productId) != null && productStock.get(productId) < 0 ? productStock.get(productId) : 0)
//                            + orderQuantity, Integer::sum);
//                }
//            }

            for (Map.Entry<Integer, Integer> entry : productStock.entrySet()) {
                Integer productId = entry.getKey();
                Integer stock = Math.max(entry.getValue(), 0);
                // 調用 repository 方法，執行插入或更新
                productStockRepository.upsertProductStock(productId, orderPackagingDTO.getPackageName(), stock);
            }


            for (Map.Entry<Integer, Integer> entry : productToGoStock.entrySet()) {
                Integer productId = entry.getKey();
                Integer stock = entry.getValue();
                // 調用 repository 方法，執行插入或更新
                productStockRepository.upsertProductStock(productId, orderPackagingDTO.getPackagingToGoName(), stock);
            }

            return null;
        }catch (Exception e){
            return "打包失敗";
        }
    }

    @Override
    public List<String> getPackageName() {
        try {
            List<String> packageName = ordersRepository.getPackageName();
            return packageName;
        }catch (Exception e){
            return null;
        }
    }
}
