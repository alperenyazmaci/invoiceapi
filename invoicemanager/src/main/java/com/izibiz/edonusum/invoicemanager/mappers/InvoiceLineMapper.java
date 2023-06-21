package com.izibiz.edonusum.invoicemanager.mappers;

import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import com.izibiz.edonusum.invoicemanager.dto.InvoiceLineDto;
import com.izibiz.edonusum.invoicemanager.entity.InvoiceLineEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface InvoiceLineMapper {

    InvoiceLine invoiceLineEntityToInvoiceLine(InvoiceLineEntity invoiceLineEntity);
    InvoiceLineEntity invoiceLineToInvoiceLineEntity(InvoiceLine invoiceLine);

    InvoiceLine invoiceLineDtoToInvoiceLine(InvoiceLineDto invoiceLineDto);
    InvoiceLineDto invoiceLineToInvoiceLineDto(InvoiceLine invoiceLine);

    List<InvoiceLine> invoiceLineEntityListToInvoiceLineList(List<InvoiceLineEntity> invoiceLineEntityList);
    List<InvoiceLineEntity> invoiceLineListToInvoiceLineEntityList(List<InvoiceLine> invoiceLineList);

    List<InvoiceLine> invoiceLineDtoListToInvoiceLineList(List<InvoiceLineDto> invoiceLineDtoList);
    List<InvoiceLineDto> invoiceLineListToInvoiceLineDtoList(List<InvoiceLine> invoiceLineList);

}
