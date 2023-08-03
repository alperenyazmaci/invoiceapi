package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.CustomerAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.exception.InvalidInfoException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CustomerService {

    private final CustomerAdapter customerAdapter;

    public CustomerService (CustomerAdapter customerAdapter){
        this.customerAdapter = customerAdapter;
    }

    public Customer findCustomerById(Long id){
        Optional<Customer> customer = customerAdapter.findCustomerById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            throw new InvalidInfoException("Customer not found.");
        }
    }
    public List<Customer> listCustomers(){
        return customerAdapter.listCustomers();
    }
    public Customer createCustomer(Customer customer) {
        Customer dbCustomer = findCustomerById(customer.getId());
        if (dbCustomer == null) {
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
        }else
            throw new InvalidInfoException("Customer already exists, use POST method");
        return customer;
    }
    public boolean deleteCustomer(Customer customer){
        Customer dbCustomer = findCustomerById(customer.getId());
        if(dbCustomer == null){
            throw new InvalidInfoException("Customer does not exist");
        }else{
            customerAdapter.deleteCustomer(customer);
            return true;
        }
    }
    public Customer updateCustomer(Customer updatedCustomer){
        Customer dbCustomer = findCustomerById(updatedCustomer.getId());
        if (dbCustomer == null){
            throw new InvalidInfoException("Customer does not exist");
        }else{
            if (Validations.customerValidation(updatedCustomer))
                return customerAdapter.createCustomer(updatedCustomer);
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
        }
        return updatedCustomer;
    }


}
