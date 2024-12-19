package carmen.purchasing_agent.purchase.service;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import carmen.purchasing_agent.core.entity.Customer;

import java.util.List;

public interface CustomerService {
    String createCustomer(CustomerDTO customerDTO);

    Customer getCustomerById(Integer customerId);

    Customer getCustomerByPhone(String phone);

    List<Customer> getAllCustomer();

    String deleteCustomer(Integer customerId);

    String modifyCustomer(CustomerDTO customerDTO);
}
