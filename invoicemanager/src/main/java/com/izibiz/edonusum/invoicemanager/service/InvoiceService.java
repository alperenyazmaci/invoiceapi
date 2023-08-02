package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.InvoiceAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class InvoiceService {

    private final InvoiceAdapter invoiceAdapter;

    public InvoiceService (InvoiceAdapter invoiceAdapter){
        this.invoiceAdapter = invoiceAdapter;
    }

    public Invoice findInvoiceById(Long id){return invoiceAdapter.findInvoiceById(id).get();}
    public List<Invoice> listInvoices(){return invoiceAdapter.listInvoices();}
    public Invoice createInvoice(Invoice invoice){
        return null;
    }
    public boolean deleteInvoice(Invoice invoice){
        Invoice dbInvoice = findInvoiceById(invoice.getId());
        if(dbInvoice == null){
            return false;
        }else{
            invoiceAdapter.deleteInvoice(invoice);
            return true;
        }
    }
    public Invoice updateInvoice (Invoice updatedInvoice){
        Invoice dbInvoice = findInvoiceById(updatedInvoice.getId());
        if(dbInvoice == null){
            return null;
        }else{
            return invoiceAdapter.updateInvoice(updatedInvoice);
        }
    }

}
