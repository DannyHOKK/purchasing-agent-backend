package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.OrderPackagingDTO;
import carmen.purchasing_agent.core.dto.OrdersDTO;
import carmen.purchasing_agent.core.entity.Orders;

import java.util.List;

public interface OrdersService {
    String createOrder(OrdersDTO ordersDTO);

    List<Orders> getAllOrders(String packageName);

    String deleteOrderById(Integer orderId);


    String changeStatusOrder(OrdersDTO ordersDTO);

    String modifyOrder(OrdersDTO ordersDTO);

    String changePaidOrder(OrdersDTO ordersDTO);

    String changeTakeMethodOrder(OrdersDTO ordersDTO);

    String changePaymentMethod(OrdersDTO ordersDTO);

    String batchPackaging(OrderPackagingDTO orderPackagingDTO);

    List<String> getPackageName();
}
