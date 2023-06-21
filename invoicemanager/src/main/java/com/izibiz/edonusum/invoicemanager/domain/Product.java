package com.izibiz.edonusum.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private long id;
    private String name;
    private String barcode;
    private double unitPrice;
    private double unitAmount;
    private String unitType;
    private float kdv;
    private String marka;

}
