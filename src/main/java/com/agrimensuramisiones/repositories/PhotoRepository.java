
package com.agrimensuramisiones.repositories;

import com.agrimensuramisiones.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
    
}
