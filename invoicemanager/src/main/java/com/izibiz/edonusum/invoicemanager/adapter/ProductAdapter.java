package com.izibiz.edonusum.invoicemanager.adapter;

import com.izibiz.edonusum.invoicemanager.dao.ProductDao;
import com.izibiz.edonusum.invoicemanager.domain.Product;
import com.izibiz.edonusum.invoicemanager.entity.CustomerEntity;
import com.izibiz.edonusum.invoicemanager.entity.ProductEntity;
import com.izibiz.edonusum.invoicemanager.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductAdapter {

    private final ProductDao productDao;

    public ProductAdapter(ProductDao productDao) {
        this.productDao = productDao;
    }

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    public Product findProductById(Long id){
        Optional<ProductEntity> o = productDao.findById(id);
        if(o.isPresent()){
            return mapper.productEntityToProduct(o.get());
        }else{
            return null;
        }
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
