package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Orders;

import java.util.List;

public interface OrdersService {
    String createOrder(OrdersDTO ordersDTO);

    List<Orders> getAllOrders();

    String deleteOrderById(Integer orderId);


    String changeStatusOrder(OrdersDTO ordersDTO);

    String modifyOrder(OrdersDTO ordersDTO);

    String changePaidOrder(OrdersDTO ordersDTO);

    String changeTakeMethodOrder(OrdersDTO ordersDTO);

    String changePaymentMethod(OrdersDTO ordersDTO);
}
