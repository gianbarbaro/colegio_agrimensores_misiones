
package com.agrimensuramisiones.repositories;

import com.agrimensuramisiones.entities.User;
import com.agrimensuramisiones.enums.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    @Query("SELECT u FROM User u WHERE u.rol LIKE :partner")
    public List<User> findParteners(@Param("partner") Rol rol);
    
    @Query("SELECT u FROM User u WHERE u.rol LIKE :authority")
    public List<User> findAuthorities(@Param("authority") Rol rol);
}
