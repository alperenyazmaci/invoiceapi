package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.domain.Customer;

public class Validations {

    public static boolean emailValidation(String email){
        return false;
    }

    public static boolean identifierValidation(String identifier){
        return false;
    }

    public static boolean phoneNumberValidation(String phoneNumber){
        return false;
    }

    public static boolean customerValidation(Customer customer){
        if(emailValidation(customer.getEmail()) && identifierValidation(customer.getIdentifier())
            && phoneNumberValidation(customer.getPhoneNumber())){
            return true;
        }else{
            return false;
        }
    }

}
