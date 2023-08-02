package com.izibiz.edonusum.invoicemanager.controller;


import com.izibiz.edonusum.invoicemanager.dto.InvoiceDto;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceMapper;
import com.izibiz.edonusum.invoicemanager.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
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
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto){
        return null;
    }

    @PutMapping()
    public InvoiceDto updateInvoice(InvoiceDto invoice){
        return null;
    }

    @DeleteMapping("/{invoiceId}")
    public void deleteInvoice(@PathVariable Long id){
        InvoiceDto dbInvoice = findInvoiceById(id);
        if(dbInvoice == null){
            System.out.println("Invoice does not exist.");
        }else{
            //invoiceService.deleteInvoice(dbInvoice);
        }
    }

    @GetMapping()
    public List<InvoiceDto> listInvoices(){
        //return invoiceService.listInvoices();
        return null;
    }

    @GetMapping("/{invoiceId}")
    public InvoiceDto findInvoiceById(@PathVariable Long id){
        //return (invoiceService.findInvoiceById(id));
        return null;
    }

}
