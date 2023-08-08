package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.InvoiceLineAdapter;
import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import com.izibiz.edonusum.invoicemanager.exception.InvalidInfoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceLineService {

    private final InvoiceLineAdapter invoiceLineAdapter;

    public InvoiceLineService (InvoiceLineAdapter invoiceLineAdapter){
        this.invoiceLineAdapter = invoiceLineAdapter;
    }

    public InvoiceLine findInvoiceLineById(Long id){
        InvoiceLine invoiceLine = invoiceLineAdapter.findInvoiceLineById(id);
        if(invoiceLine != null){
            return invoiceLine;
        }else{
            throw new InvalidInfoException("InvoiceLine not found.");
        }
    }
    public List<InvoiceLine> listInvoiceLines(){
        return invoiceLineAdapter.listInvoiceLines();
    }
    public InvoiceLine createInvoiceLine(InvoiceLine invoiceLine){
        InvoiceLine dbInvoiceLine = invoiceLineAdapter.findInvoiceLineById(invoiceLine.getId());
        if (dbInvoiceLine != null) {
            throw new InvalidInfoException("InvoiceLine already exists, use PUT method");
        }else {
            return invoiceLineAdapter.createInvoiceLine(invoiceLine);
        }
    }
    public boolean deleteInvoiceLine(InvoiceLine invoiceLine){
        InvoiceLine dbInvoiceLine = invoiceLineAdapter.findInvoiceLineById(invoiceLine.getId());
        if (dbInvoiceLine != null) {
            invoiceLineAdapter.deleteInvoiceLine(invoiceLine);
            return true;
        }else {
            throw new InvalidInfoException("InvoiceLine does not exists");
        }
    }
    public InvoiceLine updateInvoiceLine (InvoiceLine updatedInvoiceLine){
        InvoiceLine dbInvoiceLine = invoiceLineAdapter.findInvoiceLineById(updatedInvoiceLine.getId());
        if (dbInvoiceLine != null) {
            return invoiceLineAdapter.updateInvoiceLine(updatedInvoiceLine);
        }else {
            throw new InvalidInfoException("InvoiceLine does not exists");
        }
    }

}
