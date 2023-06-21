package com.izibiz.edonusum.invoicemanager.mappers;

import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.dto.CustomerDto;
import com.izibiz.edonusum.invoicemanager.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CustomerMapper {

    Customer customerEntityToCustomer(CustomerEntity customerEntity);
    CustomerEntity customerToCustomerEntity(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);

    List<Customer> customerEntityListToCustomerList(List<CustomerEntity> customerEntityList);
    List<CustomerEntity> customerListToCustomerEntityList(List<Customer> customerList);

    List<Customer> customerDtoListToCustomerList(List<CustomerDto> customerDtoList);
    List<CustomerDto> customerListToCustomerDtoList(List<Customer> customerList);

}
