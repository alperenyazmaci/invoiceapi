package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.CustomerAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.exception.InvalidInfoException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CustomerService {

    private final CustomerAdapter customerAdapter;

    public CustomerService (CustomerAdapter customerAdapter){
        this.customerAdapter = customerAdapter;
    }

    public Customer findCustomerById(Long id){
        Customer customer = customerAdapter.findCustomerById(id);
        if(customer != null){
            return customer;
        }else{
            throw new InvalidInfoException("Customer not found.");
        }
    }
    public List<Customer> listCustomers(){
        return customerAdapter.listCustomers();
    }
    public Customer createCustomer(Customer customer) {
        Customer dbCustomer = customerAdapter.findCustomerById(customer.getId());
        if (dbCustomer != null) {
            throw new InvalidInfoException("Customer already exists, use PUT method");
        }else {
            if (Validations.customerValidation(customer))
                return customerAdapter.createCustomer(customer);
            else {
                if (!Validations.identifierValidation(customer.getIdentifier()))
                    throw new InvalidInfoException("Please enter a valid identifier");
                else if (!Validations.phoneNumberValidation(customer.getPhoneNumber()))
                    throw new InvalidInfoException("Please enter a valid phone number");
                else if (!Validations.emailValidation(customer.getEmail()))
                    throw new InvalidInfoException("Please enter a valid email");
                else if (customer.getName().isEmpty())
                    throw new InvalidInfoException("Please enter a name");
                else if (customer.getSurname().isEmpty())
                    throw new InvalidInfoException("Please enter a surname");
            }
        }
        return customer;
    }
    public boolean deleteCustomer(Customer customer){
        Customer dbCustomer = customerAdapter.findCustomerById(customer.getId());
        if(dbCustomer != null){
            customerAdapter.deleteCustomer(customer);
            return true;
        }else{
            throw new InvalidInfoException("Customer does not exist");
        }
    }
    public Customer updateCustomer(Customer updatedCustomer){
        Customer dbCustomer = customerAdapter.findCustomerById(updatedCustomer.getId());
        System.out.println("Service");
        System.out.println(dbCustomer);
        if(dbCustomer != null){
            if (Validations.customerValidation(updatedCustomer))
                return customerAdapter.updateCustomer(updatedCustomer);
            else {
                if (!Validations.identifierValidation(updatedCustomer.getIdentifier()))
                    throw new InvalidInfoException("Please enter a valid identifier");
                else if (!Validations.phoneNumberValidation(updatedCustomer.getPhoneNumber()))
                    throw new InvalidInfoException("Please enter a valid phone number");
                else if (!Validations.emailValidation(updatedCustomer.getEmail()))
                    throw new InvalidInfoException("Please enter a valid email");
                else if (updatedCustomer.getName().isEmpty())
                    throw new InvalidInfoException("Please enter a name");
                else if (updatedCustomer.getSurname().isEmpty())
                    throw new InvalidInfoException("Please enter a surname");
            }
        }else{
            throw new InvalidInfoException("Customer does not exist");
        }
        return updatedCustomer;
    }


}
