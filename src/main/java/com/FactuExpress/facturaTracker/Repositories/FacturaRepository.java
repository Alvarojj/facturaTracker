package com.FactuExpress.facturaTracker.Repositories;

import com.FactuExpress.facturaTracker.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    @Query(value = "select id from comercio where nit = ?1",
    nativeQuery = true)
    int findByNit(int nit);

    @Query(value = "select id from usuario where cedula = ?1",
    nativeQuery = true)
    int findById(int id);





}
