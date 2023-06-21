package com.izibiz.edonusum.invoicemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "unit_amount")
    private double unitAmount;
    @Column(name = "unit_type")
    private String unitType;
    @Column(name = "kdv")
    private float kdv;
    @Column(name = "marka")
    private String marka;

}
