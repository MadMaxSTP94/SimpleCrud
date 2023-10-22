package com.rest40.demo.controller;

import com.rest40.demo.model.Customer;
import com.rest40.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {
    @Autowired
    private CustomerService customerService;
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Customer customer = customerService.getCustomerById(id);
        if(customer == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        HttpHeaders  headers = new HttpHeaders();
        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if(customers == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(customers, headers, HttpStatus.OK);
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer) {
        if(customer == null) return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        customerService.deleteCustomerById(customer.getId());
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer) {
        if(customer == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        customerService.saveCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Customer customer = customerService.getCustomerById(id);
        if(customer == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }

}
