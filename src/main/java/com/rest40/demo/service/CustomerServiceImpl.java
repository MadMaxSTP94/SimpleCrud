package com.rest40.demo.service;

import com.rest40.demo.model.Customer;
import com.rest40.demo.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        log.info("from CustomerServiceImpl getCustomerById()", id);
        return customerRepository.findById(id).get();
    }

    @Override
    public void saveCustomer(Customer customer) {
        log.info("from CustomerServiceImpl saveCustomer()", customer);
        this.customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        log.info("from CustomerServiceImpl deleteCustomerById()", id);
        this.customerRepository.deleteById(id.longValue());
    }

    @Override
    public List<Customer> getAllCustomers() {
        log.info("from CustomerServiceImpl getAllCustomers()");
        return customerRepository.findAll();
    }
}
