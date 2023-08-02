package com.izibiz.edonusum.invoicemanager.service;

import com.izibiz.edonusum.invoicemanager.adapter.ProductAdapter;
import com.izibiz.edonusum.invoicemanager.domain.Product;
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

    public Product findProductById(Long id){  return productAdapter.findProductById(id).get();  }
    public List<Product> listProducts(){
        return productAdapter.listProducts();
    }
    public Product createProduct(Product product){
        return productAdapter.createProduct(product);
    }
    public void deleteProduct(Product product){
        productAdapter.deleteProduct(product);
    }
    public Product updateProduct (Product updatedProduct){
        return productAdapter.updateProduct(updatedProduct);
    }

}
