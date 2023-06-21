package com.izibiz.edonusum.invoicemanager.controller;

import com.izibiz.edonusum.invoicemanager.dto.CustomerDto;
import com.izibiz.edonusum.invoicemanager.mappers.CustomerMapper;
import com.izibiz.edonusum.invoicemanager.service.CustomerService;
import com.izibiz.edonusum.invoicemanager.service.Validations;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    @PostMapping()
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        if(Validations.customerValidation(mapper.customerDtoToCustomer(customerDto))){
            customerService.createCustomer(mapper.customerDtoToCustomer(customerDto));
            return customerDto;
        }else{
            return null;
        }
    }

    @PutMapping()
    public CustomerDto updateCustomer(CustomerDto customerDto){
        CustomerDto dbCustomer = findCustomerById(customerDto.getId());
        if (dbCustomer == null){
            return null;
        }else{
            if(Validations.customerValidation(mapper.customerDtoToCustomer(customerDto))){
                customerService.updateCustomer(mapper.customerDtoToCustomer(customerDto));
                return customerDto;
            }else{
                return null;
            }
        }
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long id){
        CustomerDto dbCustomer = findCustomerById(id);
        if(dbCustomer == null){
            System.out.println("Customer does not exist.");
        }else{
            customerService.deleteCustomer(mapper.customerDtoToCustomer(dbCustomer));
        }
    }

    @GetMapping()
    public List<CustomerDto> listCustomers(){
        return mapper.customerListToCustomerDtoList(customerService.listCustomers());
    }

    @GetMapping("/{customerId}")
    public CustomerDto findCustomerById(@PathVariable Long id){
        return mapper.customerToCustomerDto(customerService.findCustomerById(id).get());
    }

}
