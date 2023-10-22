package com.rest40.demo.service;
import com.rest40.demo.model.Customer;

import java.util.List;


public interface CustomerService {
    Customer getCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomerById(Long id);
    List<Customer> getAllCustomers();

}
