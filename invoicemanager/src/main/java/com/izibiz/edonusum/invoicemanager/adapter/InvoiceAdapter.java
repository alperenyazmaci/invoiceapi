package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.InvoiceDao;
import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import com.izibiz.edonusum.invoicemanager.entity.InvoiceEntity;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InvoiceAdapter {

    private final InvoiceDao invoiceDao;

    public InvoiceAdapter(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    private InvoiceMapper mapper = Mappers.getMapper(InvoiceMapper.class);

    public Invoice findInvoiceById(Long id){
        Optional<InvoiceEntity> o = invoiceDao.findById(id);
        if(o.isPresent()){
            return mapper.invoiceEntityToInvoice(o.get());
        }else{
            return null;
        }
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
