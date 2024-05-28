package com.FactuExpress.facturaTracker.Repositories;


import com.FactuExpress.facturaTracker.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
