package com.izibiz.edonusum.invoicemanager.dao;

import com.izibiz.edonusum.invoicemanager.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDao extends JpaRepository<InvoiceEntity, Long> {



}

