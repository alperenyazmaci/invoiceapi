package com.izibiz.edonusum.invoicemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CustomerDto {

    private long id;
    private String name;
    private String surname;
    private String identifier;
    private String phoneNumber;
    private String email;
    private String title;
    private String taxOffice;


    public CustomerDto(long id, String name, String surname, String identifier, String phoneNumber, String email, String title, String taxOffice) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.identifier = identifier;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.title = title;
        this.taxOffice = taxOffice;
    }

    public CustomerDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }
}
