package carmen.purchasing_agent.purchase.service.Impl;

import carmen.purchasing_agent.core.dto.CustomerDTO;
import carmen.purchasing_agent.core.entity.Customer;
import carmen.purchasing_agent.purchase.repository.CustomerRepository;
import carmen.purchasing_agent.purchase.service.CustomerService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(CustomerDTO customerDTO) {


        if (StringUtils.isEmpty(customerDTO.getInstagram()) && StringUtils.isEmpty(customerDTO.getPhone())) {
            return "電話 / Instagram 不能空白";
        }

        if (checkCustomerExistFunction(customerDTO.getPhone(), customerDTO.getInstagram())){
            return "電話/IG已被註冊";
        }

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
        if (StringUtils.isEmpty(phone)){
            return null;
        }
        Customer customer = customerRepository.findByPhone(phone);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        try {
            customerRepository.deleteById(customerId);
            return null;
        }catch (Exception e){
            return "刪除失敗，客人有落訂單，請先刪除訂單";
        }
    }

    @Override
    public String modifyCustomer(CustomerDTO customerDTO) {

        try {

            if (StringUtils.isEmpty(customerDTO.getInstagram()) && StringUtils.isEmpty(customerDTO.getPhone())) {
                return "電話 / Instagram 不能空白";
            }

            Customer customer = customerRepository.findById(customerDTO.getCustomerId()).orElseThrow();

            if(!StringUtils.equals(customer.getPhone(),customerDTO.getPhone())){

                if (StringUtils.isNotEmpty(customerDTO.getPhone())){

                    Customer checkExistCustomer = customerRepository.findByPhone(customerDTO.getPhone());
                    if(ObjectUtils.isNotEmpty(checkExistCustomer)){
                        return "電話/IG已被註冊";
                    }
                }

            }


            if (!StringUtils.equals(customer.getInstagram(),customerDTO.getInstagram())){

                if (StringUtils.isNotEmpty(customerDTO.getInstagram())){

                    Customer checkExistIg = customerRepository.findByInstagram(customerDTO.getInstagram());

                    if (ObjectUtils.isNotEmpty(checkExistIg) ){
                        return "電話/IG已被註冊";
                    }

                }
            }


            customer.setPhone(customerDTO.getPhone());
            customer.setInstagram(customerDTO.getInstagram());
            customer.setRemark(customerDTO.getRemark());
            customer.setShippingAddress(customerDTO.getShippingAddress());
            customer.setModifyDate(new Date());

            customerRepository.save(customer);

            return null;
        }catch (Exception e){
            return "更改失敗";
        }

    }

    @Override
    public String checkCustomerExist(CustomerDTO customerDTO) {
        Boolean exist = checkCustomerExistFunction(customerDTO.getPhone(),customerDTO.getInstagram());
        if (BooleanUtils.isTrue(exist)){
            return null;
        }else{
            return "客人資料存在";
        }
    }

    public Boolean checkCustomerExistFunction (String phone, String instagram){


        if (!StringUtils.isEmpty(phone)){
            Customer checkExistCustomer = customerRepository.findByPhone(phone);

            if(ObjectUtils.isNotEmpty(checkExistCustomer) && StringUtils.isNotEmpty(phone)){
                return true;
            }
        }

        if (!StringUtils.isEmpty(instagram)){

            Customer checkExistIg = customerRepository.findByInstagram(instagram);
            if (ObjectUtils.isNotEmpty(checkExistIg) && StringUtils.isNotEmpty(instagram)){
                return true;
            }
        }


        return false;
    }
}
