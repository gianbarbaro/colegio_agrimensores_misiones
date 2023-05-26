
package com.agrimensuramisiones.repositories;

import com.agrimensuramisiones.entities.Normative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormativeRepository extends JpaRepository<Normative, String> {
    
}
