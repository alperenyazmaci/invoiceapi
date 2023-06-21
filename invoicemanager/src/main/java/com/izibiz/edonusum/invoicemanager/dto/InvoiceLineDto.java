package com.izibiz.edonusum.invoicemanager.dto;

import com.izibiz.edonusum.invoicemanager.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineDto {

    private long id;
    private long productId;
    private long invoiceId;
    private double quantity;
    private double lineTotal;
    private double lineKdvTotal;

}
