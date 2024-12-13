package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.core.entity.Orders;
import carmen.purchasing_agent.core.entity.Product;
import carmen.purchasing_agent.purchase.repository.CustomerRepository;
import carmen.purchasing_agent.purchase.repository.OrdersRepository;
import carmen.purchasing_agent.purchase.repository.ProductRepository;
import carmen.purchasing_agent.purchase.service.OrdersService;
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

        orders.setProduct(product);
        orders.setQuantity(orders.getQuantity());
        orders.setCreateDate(new Date());
        orders.setModifyDate(new Date());
        if (orders.getPaid() == true){
            orders.setStatus("已付款");
        }else {
            orders.setStatus("未付款");
        }

        product.setQuantity(orders.getQuantity());
        productRepository.save(product);
        ordersRepository.save(orders);

        return null;
    }

    @Override
    public List<Orders> getAllOrders() {

        List<Orders> ordersList = ordersRepository.findAll();

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
}
