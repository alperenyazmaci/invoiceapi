package com.izibiz.edonusum.invoicemanager.mappers;

import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import com.izibiz.edonusum.invoicemanager.dto.InvoiceDto;
import com.izibiz.edonusum.invoicemanager.entity.InvoiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface InvoiceMapper {


    Invoice invoiceEntityToInvoice(InvoiceEntity invoiceEntity);
    InvoiceEntity invoiceToInvoiceEntity(Invoice invoice);

    Invoice invoiceDtoToInvoice(InvoiceDto invoiceDto);
    InvoiceDto invoiceToInvoiceDto(Invoice invoice);


    List<Invoice> invoiceEntityListToInvoiceList(List<InvoiceEntity> invoiceEntityList);
    List<InvoiceEntity> invoiceListToInvoiceEntityList(List<Invoice> invoiceList);

    List<Invoice> invoiceDtoListToInvoiceList(List<InvoiceDto> invoiceDtoList);
    List<InvoiceDto> invoiceListToInvoiceDtoList(List<Invoice> invoiceList);

}
