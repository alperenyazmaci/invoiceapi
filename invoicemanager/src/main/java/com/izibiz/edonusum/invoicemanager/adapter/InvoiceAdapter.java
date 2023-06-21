package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.InvoiceDao;
import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import com.izibiz.edonusum.invoicemanager.entity.InvoiceEntity;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class InvoiceAdapter {

    private final InvoiceDao invoiceDao;
    private InvoiceMapper mapper = Mappers.getMapper(InvoiceMapper.class);

    public Optional<Invoice> findInvoiceById(Long id){
//        Invoice invoice = mapper.invoiceEntityToInvoice(invoiceDao.findById(id).get());
//        Optional<Invoice> result = Optional.of(invoice);
        return Optional.of(mapper.invoiceEntityToInvoice(invoiceDao.findById(id).get()));
    }
    public List<Invoice> listInvoices(){
        return mapper.invoiceEntityListToInvoiceList(invoiceDao.findAll());
    }
    public Invoice createInvoice(Invoice invoice){
        InvoiceEntity invoiceEntity = mapper.invoiceToInvoiceEntity(invoice);
        invoiceDao.save(invoiceEntity);
        return invoice;
    }
    public void deleteInvoice(Invoice invoice){
        InvoiceEntity invoiceEntity = mapper.invoiceToInvoiceEntity(invoice);
        invoiceDao.delete(invoiceEntity);
    }
    public Invoice updateInvoice (Invoice updatedInvoice){
        InvoiceEntity invoiceEntity = mapper.invoiceToInvoiceEntity(updatedInvoice);
        invoiceDao.save(invoiceEntity);
        return updatedInvoice;
    }

}
