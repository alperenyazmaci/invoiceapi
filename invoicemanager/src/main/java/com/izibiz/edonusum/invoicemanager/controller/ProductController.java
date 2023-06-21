package com.izibiz.edonusum.invoicemanager.controller;

import com.izibiz.edonusum.invoicemanager.dto.ProductDto;
import com.izibiz.edonusum.invoicemanager.mappers.ProductMapper;
import com.izibiz.edonusum.invoicemanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @PostMapping()
    public ProductDto createProduct(@RequestBody ProductDto theProduct){

        theProduct.setId(0);
        return productService.createProduct(theProduct);
    }

    @PutMapping()
    public ProductDto updateProduct(ProductDto product){
        ProductDto dbProduct = findProductById(product.getId());
        if(dbProduct == null){
            System.out.println("Product does not exist.");
            return null;
        }else{
            return productService.updateProduct(product);
        }
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long id){
        ProductDto dbProduct = findProductById(id);
        if(dbProduct == null){
            System.out.println("Product does not exist.");
        }else{
            productService.deleteProduct(dbProduct);
        }
    }

    @GetMapping()
    public List<ProductDto> listProducts(){
        return productService.listProducts();
    }

    @GetMapping("/{productId}")
    public ProductDto findProductById(@PathVariable Long id){
        return (productService.findProductById(id));
    }

}
