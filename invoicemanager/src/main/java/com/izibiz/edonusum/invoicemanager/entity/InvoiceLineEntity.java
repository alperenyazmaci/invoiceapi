package com.izibiz.edonusum.invoicemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="invoice_line", schema="invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "product_id_fk")
    private long productId;
    @Column(name = "invoice_id_fk")
    private long invoiceId;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "line_total")
    private double lineTotal;
    @Column(name = "line_kdv_total")
    private double lineKdvTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public double getLineKdvTotal() {
        return lineKdvTotal;
    }

    public void setLineKdvTotal(double lineKdvTotal) {
        this.lineKdvTotal = lineKdvTotal;
    }
}
