package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.InvoiceAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceAdapter invoiceAdapter;

    public Optional<Invoice> findInvoiceById(Long id){return invoiceAdapter.findInvoiceById(id);}
    public List<Invoice> listInvoices(){return invoiceAdapter.listInvoices();}
    public Invoice createInvoice(Invoice invoice){
        return invoiceAdapter.createInvoice(invoice);
    }
    public void deleteInvoice(Invoice invoice){
        invoiceAdapter.deleteInvoice(invoice);
    }
    public Invoice updateInvoice (Invoice updatedInvoice){
        return invoiceAdapter.updateInvoice(updatedInvoice);
    }

}
