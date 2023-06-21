package com.izibiz.edonusum.invoicemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private long customerId;
    @Column(name = "price")
    private double amount;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "total_kdv")
    private double totalKdv;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(name = "time_created")
    private LocalTime timeCreated;
    @Column(name = "currency")
    private String currency;
    @Column(name = "uuid")
    private String UUID;
    @Column(name = "invoice_status")
    private String invoiceStatus;

}
