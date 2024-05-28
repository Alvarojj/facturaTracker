package com.FactuExpress.facturaTracker.Repositories;

import com.FactuExpress.facturaTracker.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByCedula(String id);
}
