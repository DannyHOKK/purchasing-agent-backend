package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.OrderPackagingDTO;
import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Orders;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.purchase.repository.CustomerRepository;
import carmen.purchasing_agent.purchase.repository.OrdersRepository;
import carmen.purchasing_agent.purchase.repository.ProductRepository;
import carmen.purchasing_agent.purchase.service.OrdersService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
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
        orders.setOrderPlatform(ordersDTO.getOrderPlatform());
        orders.setProduct(product);
        orders.setQuantity(orders.getQuantity());
        orders.setCreateDate(new Date());
        orders.setModifyDate(new Date());
        orders.setStatus("備貨中");
        orders.setPackageName(ordersDTO.getPackageName());

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
    @Transactional
    public String batchPackaging(OrderPackagingDTO orderPackagingDTO) {

        try {
            ordersRepository.batchUpdatePackageNameByOrderIds(orderPackagingDTO.getOrderIdList(), orderPackagingDTO.getPackageName());
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
