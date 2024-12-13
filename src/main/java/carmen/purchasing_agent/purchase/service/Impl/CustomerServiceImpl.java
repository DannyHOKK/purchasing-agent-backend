package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.purchase.repository.CustomerRepository;
import carmen.purchasing_agent.purchase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(customerDTO);

        customer.setCreateDate(new Date());
        customer.setModifyDate(new Date());

        customerRepository.save(customer);

        return null;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return customer;
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        Customer customer = (Customer) customerRepository.findByPhone(phone).orElseThrow();
        return customer;
    }
}
