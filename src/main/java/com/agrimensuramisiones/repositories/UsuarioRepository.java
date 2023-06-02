
package com.agrimensuramisiones.repositories;

import com.agrimensuramisiones.entities.Usuario;
import com.agrimensuramisiones.enums.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
    @Query("SELECT u FROM Usuario u WHERE u.email LIKE :email")
    public Usuario findByEmail(@Param("email") String email);
    
    @Query("SELECT u FROM Usuario u WHERE u.rol LIKE :partner")
    public List<Usuario> findParteners(@Param("partner") Rol rol);
    
    @Query("SELECT u FROM Usuario u WHERE u.rol LIKE :authority")
    public List<Usuario> findAuthorities(@Param("authority") Rol rol);
}
