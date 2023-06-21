package com.izibiz.edonusum.invoicemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="invoice_line")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private long productId;
    private long invoiceId;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "line_total")
    private double lineTotal;
    @Column(name = "line_kdv_total")
    private double lineKdvTotal;

}
