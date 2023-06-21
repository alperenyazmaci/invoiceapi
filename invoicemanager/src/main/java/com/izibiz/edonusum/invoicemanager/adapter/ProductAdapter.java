package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.ProductDao;
import com.izibiz.edonusum.invoicemanager.domain.Product;
import com.izibiz.edonusum.invoicemanager.entity.ProductEntity;
import com.izibiz.edonusum.invoicemanager.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductAdapter {

    private final ProductDao productDao;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    public Optional<Product> findProductById(Long id){
//        Product product = mapper.productEntityToProduct(productDao.findById(id).get());
//        Optional<Product> result = Optional.of(product);
        return Optional.of(mapper.productEntityToProduct(productDao.findById(id).get()));
    }
    public List<Product> listProducts(){
        return mapper.productEntityListToProductList(productDao.findAll());
    }
    public Product createProduct(Product product){
        ProductEntity productEntity = mapper.productToProductEntity(product);
        productDao.save(productEntity);
        return product;
    }
    public void deleteProduct(Product product){
        ProductEntity productEntity = mapper.productToProductEntity(product);
        productDao.delete(productEntity);
    }
    public Product updateProduct (Product updatedProduct){
        ProductEntity productEntity = mapper.productToProductEntity(updatedProduct);
        productDao.save(productEntity);
        return updatedProduct;
    }

}
