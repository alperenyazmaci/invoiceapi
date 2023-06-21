package com.izibiz.edonusum.invoicemanager.dao;

import com.izibiz.edonusum.invoicemanager.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {



}
