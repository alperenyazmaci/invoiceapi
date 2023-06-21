package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.CustomerAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerAdapter customerAdapter;

    public Optional<Customer> findCustomerById(Long id){
        return customerAdapter.findCustomerById(id);
    }
    public List<Customer> listCustomers(){
        return customerAdapter.listCustomers();
    }
    public Customer createCustomer(Customer customer){
        return customerAdapter.createCustomer(customer);
    }
    public void deleteCustomer(Customer customer){
        customerAdapter.deleteCustomer(customer);
    }
    public Customer updateCustomer (Customer updatedCustomer){return customerAdapter.updateCustomer(updatedCustomer);}


}
