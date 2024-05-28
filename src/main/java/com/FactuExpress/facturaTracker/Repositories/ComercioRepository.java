package com.FactuExpress.facturaTracker.Repositories;

import com.FactuExpress.facturaTracker.Models.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ComercioRepository extends JpaRepository<Comercio, Integer> {

 Comercio findByNit(int nit);
}
