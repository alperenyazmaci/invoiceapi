package com.izibiz.edonusum.invoicemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private long id;
    private String name;
    private String surname;
    private String identifier;
    private String phoneNumber;
    private String email;
    private String title;
    private String taxOffice;

}
