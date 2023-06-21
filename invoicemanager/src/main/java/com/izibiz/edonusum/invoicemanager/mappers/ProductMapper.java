package com.izibiz.edonusum.invoicemanager.mappers;

import com.izibiz.edonusum.invoicemanager.domain.Product;
import com.izibiz.edonusum.invoicemanager.dto.ProductDto;
import com.izibiz.edonusum.invoicemanager.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product productEntityToProduct(ProductEntity productEntity);
    ProductEntity productToProductEntity(Product product);

    Product productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Product product);


    List<Product> productEntityListToProductList(List<ProductEntity> productEntityList);
    List<ProductEntity> productListToProductEntityList(List<Product> productList);

    List<Product> productDtoListToProductList(List<ProductDto> productDtoList);
    List<ProductDto> productListToProductDtoList(List<Product> productList);

}
