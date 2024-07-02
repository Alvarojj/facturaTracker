package com.FactuExpress.facturaTracker.Repositories;

import com.FactuExpress.facturaTracker.Models.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ComercioRepository extends JpaRepository<Comercio, Integer> {

 @Query(value = "select * from comercio where id_comercio = ?1", nativeQuery = true)
 Comercio findById(int id);
}
