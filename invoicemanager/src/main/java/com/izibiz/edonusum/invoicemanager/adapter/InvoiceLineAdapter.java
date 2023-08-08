package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.InvoiceLineDao;
import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import com.izibiz.edonusum.invoicemanager.entity.InvoiceLineEntity;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceLineMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InvoiceLineAdapter {

    private final InvoiceLineDao invoiceLineDao;

    public InvoiceLineAdapter(InvoiceLineDao invoiceLineDao) {
        this.invoiceLineDao = invoiceLineDao;
    }

    private InvoiceLineMapper mapper = Mappers.getMapper(InvoiceLineMapper.class);

    public InvoiceLine findInvoiceLineById(Long id){
        Optional<InvoiceLineEntity> o = invoiceLineDao.findById(id);
        if(o.isPresent()){
            return mapper.invoiceLineEntityToInvoiceLine(o.get());
        }else{
            return null;
        }
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
