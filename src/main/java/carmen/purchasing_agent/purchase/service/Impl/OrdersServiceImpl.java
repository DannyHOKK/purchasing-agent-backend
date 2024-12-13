package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Orders;
import carmen.purchasing_agent.purchase.repository.OrdersRepository;
import carmen.purchasing_agent.purchase.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public String createOrder(OrdersDTO ordersDTO) {

        Orders orders = new Orders(ordersDTO);

        orders.setCreateDate(new Date());
        orders.setModifyDate(new Date());

        ordersRepository.save(orders);

        return null;
    }

    @Override
    public List<Orders> getAllOrders() {

        return ordersRepository.findAll();
    }
}
