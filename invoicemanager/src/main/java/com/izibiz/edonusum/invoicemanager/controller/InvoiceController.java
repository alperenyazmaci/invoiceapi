package com.izibiz.edonusum.invoicemanager.controller;


import com.izibiz.edonusum.invoicemanager.domain.Invoice;
import com.izibiz.edonusum.invoicemanager.dto.InvoiceDto;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceMapper;
import com.izibiz.edonusum.invoicemanager.service.InvoiceService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    private InvoiceMapper mapper = Mappers.getMapper(InvoiceMapper.class);

    @PostMapping()
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto){
        invoiceService.createInvoice(mapper.invoiceDtoToInvoice(invoiceDto));
        return new ResponseEntity<>(invoiceDto, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<InvoiceDto> updateInvoice(@RequestBody InvoiceDto invoiceDto){
        invoiceService.updateInvoice(mapper.invoiceDtoToInvoice(invoiceDto));
        return new ResponseEntity<>(invoiceDto, HttpStatus.OK);
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long invoiceId){
        Invoice invoice = invoiceService.findInvoiceById(invoiceId);
        invoiceService.deleteInvoice(invoice);
        return new ResponseEntity<>("Invoice deleted", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<InvoiceDto>> listInvoices(){
        return new ResponseEntity<>(mapper.invoiceListToInvoiceDtoList(invoiceService.listInvoices()), HttpStatus.OK);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDto> findInvoiceById(@PathVariable Long invoiceId){
        return new ResponseEntity<>(mapper.invoiceToInvoiceDto(invoiceService.findInvoiceById(invoiceId)), HttpStatus.OK);
    }

}
