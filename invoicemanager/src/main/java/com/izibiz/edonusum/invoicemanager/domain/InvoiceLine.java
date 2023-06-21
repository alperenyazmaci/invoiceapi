package com.izibiz.edonusum.invoicemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLine {

    private long id;
    private long productId;
    private long invoiceId;
    private double quantity;
    private double lineTotal;
    private double lineKdvTotal;

}
