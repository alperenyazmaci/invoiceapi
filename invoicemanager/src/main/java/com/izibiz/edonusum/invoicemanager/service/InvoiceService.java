package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.InvoiceAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import com.izibiz.edonusum.invoicemanager.exception.InvalidInfoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceAdapter invoiceAdapter;

    public InvoiceService (InvoiceAdapter invoiceAdapter){
        this.invoiceAdapter = invoiceAdapter;
    }

    public Invoice findInvoiceById(Long id){
        Invoice invoice = invoiceAdapter.findInvoiceById(id);
        if(invoice != null){
            return invoice;
        }else{
            throw new InvalidInfoException("Invoice not found.");
        }
    }
    public List<Invoice> listInvoices(){
        return invoiceAdapter.listInvoices();
    }
    public Invoice createInvoice(Invoice invoice){
        Invoice dbInvoice = invoiceAdapter.findInvoiceById(invoice.getId());
        if (dbInvoice != null) {
            throw new InvalidInfoException("Invoice already exists, use PUT method");
        }else {
            return invoiceAdapter.createInvoice(invoice);
        }
    }
    public boolean deleteInvoice(Invoice invoice){
        Invoice dbInvoice = invoiceAdapter.findInvoiceById(invoice.getId());
        if (dbInvoice != null) {
            invoiceAdapter.deleteInvoice(invoice);
            return true;
        }else {
            throw new InvalidInfoException("Invoice does not exists");
        }
    }
    public Invoice updateInvoice (Invoice updatedInvoice){
        Invoice dbInvoice = invoiceAdapter.findInvoiceById(updatedInvoice.getId());
        if (dbInvoice != null) {
            return invoiceAdapter.updateInvoice(updatedInvoice);
        }else {
            throw new InvalidInfoException("Invoice does not exists");
        }
    }

}
