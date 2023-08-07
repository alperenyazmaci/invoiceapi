package com.izibiz.edonusum.invoicemanager.controller;

import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.dto.CustomerDto;
import com.izibiz.edonusum.invoicemanager.mappers.CustomerMapper;
import com.izibiz.edonusum.invoicemanager.service.CustomerService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(mapper.customerDtoToCustomer(customerDto));
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto){
        customerService.updateCustomer(mapper.customerDtoToCustomer(customerDto));
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId){
        Customer customer = customerService.findCustomerById(customerId);
        customerService.deleteCustomer(customer);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> listCustomers(){
//        CustomerDto c1 = new CustomerDto(1,"alp","yazmaci", "42778210168", "5374796693", "alperen.yazmaci@gmail.com", "title", "taxoofice");
//        List<CustomerDto> list = new ArrayList<>();
//        list.add(c1);
//        return new ResponseEntity<>(list, HttpStatus.OK);
        return new ResponseEntity<>(mapper.customerListToCustomerDtoList(customerService.listCustomers()), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Long customerId){
        return new ResponseEntity<>(mapper.customerToCustomerDto(customerService.findCustomerById(customerId)), HttpStatus.OK);
    }

}
