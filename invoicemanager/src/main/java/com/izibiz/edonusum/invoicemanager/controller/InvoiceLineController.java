package com.izibiz.edonusum.invoicemanager.controller;

import com.izibiz.edonusum.invoicemanager.dto.InvoiceLineDto;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceLineMapper;
import com.izibiz.edonusum.invoicemanager.service.InvoiceLineService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoiceLines")
public class InvoiceLineController {

    private final InvoiceLineService invoiceLineService;

    public InvoiceLineController(InvoiceLineService invoiceLineService) {
        this.invoiceLineService = invoiceLineService;
    }

    private InvoiceLineMapper mapper = Mappers.getMapper(InvoiceLineMapper.class);

    @PostMapping()
    public InvoiceLineDto createInvoiceLine(@RequestBody InvoiceLineDto theInvoiceLine){

        theInvoiceLine.setId(0);
        //return invoiceLineService.createInvoiceLine(theInvoiceLine);
        return null;
    }

    @PutMapping()
    public InvoiceLineDto updateInvoice(InvoiceLineDto invoice){
        InvoiceLineDto dbInvoice = findInvoiceLineById(invoice.getId());
        if(dbInvoice == null){
            System.out.println("InvoiceLine does not exist.");
            return null;
        }else{
            //return invoiceLineService.updateInvoice(invoice);
            return null;
        }
    }

    @DeleteMapping("/{invoiceLineId}")
    public void deleteInvoiceLine(@PathVariable Long id){
        InvoiceLineDto dbInvoiceLine = findInvoiceLineById(id);
        if(dbInvoiceLine == null){
            System.out.println("InvoiceLine does not exist.");
        }else{
            //invoiceLineService.deleteInvoiceLine(dbInvoiceLine);
        }
    }

    @GetMapping()
    public List<InvoiceLineDto> listInvoices(){
        //return invoiceLineService.listInvoiceLines();
        return null;
    }

    @GetMapping("/{invoiceLineId}")
    public InvoiceLineDto findInvoiceLineById(@PathVariable Long id){
        //return (invoiceLineService.findInvoiceLineById(id));
        return null;
    }

}
