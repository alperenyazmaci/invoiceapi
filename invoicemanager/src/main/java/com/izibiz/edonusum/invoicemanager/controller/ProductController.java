package com.izibiz.edonusum.invoicemanager.controller;

import com.izibiz.edonusum.invoicemanager.domain.Product;
import com.izibiz.edonusum.invoicemanager.dto.ProductDto;
import com.izibiz.edonusum.invoicemanager.mappers.ProductMapper;
import com.izibiz.edonusum.invoicemanager.service.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(mapper.productDtoToProduct(productDto));
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        productService.updateProduct(mapper.productDtoToProduct(productDto));
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
        Product product = productService.findProductById(productId);
        productService.deleteProduct(product);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> listProducts(){
        return new ResponseEntity<>(mapper.productListToProductDtoList(productService.listProducts()), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId){
        return new ResponseEntity<>(mapper.productToProductDto(productService.findProductById(productId)), HttpStatus.OK);
    }

}
