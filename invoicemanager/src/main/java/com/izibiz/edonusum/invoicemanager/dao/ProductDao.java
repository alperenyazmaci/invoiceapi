package com.izibiz.edonusum.invoicemanager.dao;

import com.izibiz.edonusum.invoicemanager.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {


}
