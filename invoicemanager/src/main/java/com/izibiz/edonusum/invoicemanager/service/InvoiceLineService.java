package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.InvoiceLineAdapter;
import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceLineService {

    private final InvoiceLineAdapter invoiceLineAdapter;

    public Optional<InvoiceLine> findInvoiceLineById(Long id){
        return invoiceLineAdapter.findInvoiceLineById(id);
    }
    public List<InvoiceLine> listInvoiceLines(){
        return invoiceLineAdapter.listInvoiceLines();
    }
    public InvoiceLine createInvoiceLine(InvoiceLine invoiceLine){return invoiceLineAdapter.createInvoiceLine(invoiceLine);}
    public void deleteInvoiceLine(InvoiceLine invoiceLine){
        invoiceLineAdapter.deleteInvoiceLine(invoiceLine);
    }
    public InvoiceLine updateInvoice (InvoiceLine updatedInvoiceLine){return invoiceLineAdapter.updateInvoiceLine(updatedInvoiceLine);}

}
