package com.izibiz.edonusum.invoicemanager.dao;

import com.izibiz.edonusum.invoicemanager.entity.InvoiceLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLineDao extends JpaRepository<InvoiceLineEntity, Long> {



}
