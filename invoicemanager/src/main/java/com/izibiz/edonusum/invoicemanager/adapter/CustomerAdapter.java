package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.CustomerDao;
import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.entity.CustomerEntity;
import com.izibiz.edonusum.invoicemanager.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerAdapter {

    private CustomerDao customerDao;

    public CustomerAdapter(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    public Customer findCustomerById(Long id){
        Optional<CustomerEntity> o = customerDao.findById(id);
        if(o.isPresent()){
            return mapper.customerEntityToCustomer(o.get());
        }else{
            return null;
        }
        //return Optional.of(mapper.customerEntityToCustomer(customerDao.findById(id).get()));
    }
    public List<Customer> listCustomers(){
        return mapper.customerEntityListToCustomerList(customerDao.findAll());
    }
    public Customer createCustomer(Customer customer){
        CustomerEntity customerEntity = mapper.customerToCustomerEntity(customer);
        customerDao.save(customerEntity);
        return customer;
    }
    public void deleteCustomer(Customer customer){
        CustomerEntity customerEntity = mapper.customerToCustomerEntity(customer);
        customerDao.delete(customerEntity);
    }
    public Customer updateCustomer (Customer updatedCustomer){
        CustomerEntity customerEntity = mapper.customerToCustomerEntity(updatedCustomer);
        customerDao.save(customerEntity);
        return updatedCustomer;
    }


}
