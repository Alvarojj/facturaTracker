package com.FactuExpress.facturaTracker.Repositories;

import com.FactuExpress.facturaTracker.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select * from Usuario where id_usuario = ?1", nativeQuery = true)
    Usuario findById(int id);

    @Modifying
    @Query(value = "update Usuario set ahorro_papel = ?1 where id_usuario = ?2", nativeQuery = true)
    int updateAhorro(int ahorro, int idUsuario);
}
