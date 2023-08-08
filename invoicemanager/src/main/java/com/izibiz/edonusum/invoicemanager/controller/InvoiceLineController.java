package com.izibiz.edonusum.invoicemanager.controller;

import com.izibiz.edonusum.invoicemanager.domain.InvoiceLine;
import com.izibiz.edonusum.invoicemanager.dto.InvoiceLineDto;
import com.izibiz.edonusum.invoicemanager.mappers.InvoiceLineMapper;
import com.izibiz.edonusum.invoicemanager.service.InvoiceLineService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<InvoiceLineDto> createInvoiceLine(@RequestBody InvoiceLineDto invoiceLineDto){
        invoiceLineService.createInvoiceLine(mapper.invoiceLineDtoToInvoiceLine(invoiceLineDto));
        return new ResponseEntity<>(invoiceLineDto, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<InvoiceLineDto> updateInvoiceLine(@RequestBody InvoiceLineDto invoiceLineDto){
        invoiceLineService.updateInvoiceLine(mapper.invoiceLineDtoToInvoiceLine(invoiceLineDto));
        return new ResponseEntity<>(invoiceLineDto, HttpStatus.OK);
    }

    @DeleteMapping("/{invoiceLineId}")
    public ResponseEntity<String> deleteInvoiceLine(@PathVariable Long invoiceLineId){
        InvoiceLine invoiceLine = invoiceLineService.findInvoiceLineById(invoiceLineId);
        invoiceLineService.deleteInvoiceLine(invoiceLine);
        return new ResponseEntity<>("Invoice Line deleted", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<InvoiceLineDto>> listInvoiceLines(){
        return new ResponseEntity<>(mapper.invoiceLineListToInvoiceLineDtoList(invoiceLineService.listInvoiceLines()), HttpStatus.OK);
    }

    @GetMapping("/{invoiceLineId}")
    public ResponseEntity<InvoiceLineDto> findInvoiceLineById(@PathVariable Long invoiceLineId){
        return new ResponseEntity<>(mapper.invoiceLineToInvoiceLineDto(invoiceLineService.findInvoiceLineById(invoiceLineId)), HttpStatus.OK);
    }

}
