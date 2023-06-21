package com.izibiz.edonusum.invoicemanager.dto;

import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private long id;
    private long customerId;
    private double amount;
    private double totalPrice;
    private double totalKdv;
    private LocalDate dateCreated;
    private LocalTime timeCreated;
    private String currency;
    private String UUID;
    private String invoiceStatus;

}
