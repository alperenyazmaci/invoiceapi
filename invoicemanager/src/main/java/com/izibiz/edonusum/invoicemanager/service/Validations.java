package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.domain.Customer;
import java.util.regex.Pattern;

public class Validations {

    public static boolean patternMatches(String string, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(string)
                .matches();
    }

    public static boolean emailValidation(String email){
        String regexPattern = "^(.+)@(\\S+)$";
        return patternMatches(email, regexPattern);
    }

    public static boolean identifierValidation(String identifier){
        String regexPattern1 = "^\\d{10}$";
        String regexPattern2 = "^\\d{11}$";
        return (patternMatches(identifier, regexPattern1) || patternMatches(identifier, regexPattern2));
    }

    public static boolean phoneNumberValidation(String phoneNumber){
        String regexPattern = "^\\d{10}$";
        return patternMatches(phoneNumber, regexPattern);
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
