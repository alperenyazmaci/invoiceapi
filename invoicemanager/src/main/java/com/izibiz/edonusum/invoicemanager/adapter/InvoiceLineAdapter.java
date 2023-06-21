package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.InvoiceLineDao;
import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import com.izibiz.edonusum.invoicemanager.entity.InvoiceLineEntity;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceLineMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class InvoiceLineAdapter {

    private final InvoiceLineDao invoiceLineDao;

    private InvoiceLineMapper mapper = Mappers.getMapper(InvoiceLineMapper.class);

    public Optional<InvoiceLine> findInvoiceLineById(Long id){
//        InvoiceLine invoiceLine = mapper.invoiceLineEntityToInvoiceLine(invoiceLineDao.findById(id).get());
//        Optional<InvoiceLine> result = Optional.of(invoiceLine);
        return Optional.of(mapper.invoiceLineEntityToInvoiceLine(invoiceLineDao.findById(id).get()));
    }
    public List<InvoiceLine> listInvoiceLines(){
        return mapper.invoiceLineEntityListToInvoiceLineList(invoiceLineDao.findAll());
    }
    public InvoiceLine createInvoiceLine(InvoiceLine invoiceLine){
        InvoiceLineEntity invoiceLineEntity = mapper.invoiceLineToInvoiceLineEntity(invoiceLine);
        invoiceLineDao.save(invoiceLineEntity);
        return invoiceLine;
    }
    public void deleteInvoiceLine(InvoiceLine invoiceLine){
        InvoiceLineEntity invoiceLineEntity = mapper.invoiceLineToInvoiceLineEntity(invoiceLine);
        invoiceLineDao.delete(invoiceLineEntity);
    }
    public InvoiceLine updateInvoiceLine (InvoiceLine updatedInvoiceLine){
        InvoiceLineEntity invoiceLineEntity = mapper.invoiceLineToInvoiceLineEntity(updatedInvoiceLine);
        invoiceLineDao.save(invoiceLineEntity);
        return updatedInvoiceLine;
    }

}
