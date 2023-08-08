package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.ProductAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Customer;
import com.izibiz.edonusum.invoicemanager.domain.Product;
import com.izibiz.edonusum.invoicemanager.exception.InvalidInfoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductAdapter productAdapter;

    public ProductService (ProductAdapter productAdapter){
        this.productAdapter = productAdapter;
    }

    public Product findProductById(Long id){
        Product product = productAdapter.findProductById(id);
        if(product != null){
            return product;
        }else{
            throw new InvalidInfoException("Product not found.");
        }
    }
    public List<Product> listProducts(){
        return productAdapter.listProducts();
    }
    public Product createProduct(Product product){
        Product dbProduct = productAdapter.findProductById(product.getId());
        if (dbProduct != null) {
            throw new InvalidInfoException("Product already exists, use PUT method");
        }else {
            return productAdapter.createProduct(product);
        }
    }
    public boolean deleteProduct(Product product){
        Product dbProduct = productAdapter.findProductById(product.getId());
        if (dbProduct != null) {
            productAdapter.deleteProduct(product);
            return true;
        }else {
            throw new InvalidInfoException("Product does not exists");
        }
    }
    public Product updateProduct (Product updatedProduct){
        Product dbProduct = productAdapter.findProductById(updatedProduct.getId());
        if (dbProduct != null) {
            return productAdapter.updateProduct(updatedProduct);
        }else {
            throw new InvalidInfoException("Product does not exists");
        }
    }

}
