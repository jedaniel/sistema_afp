package com.afp.solicitud.repository;

import com.afp.solicitud.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByDniAndAfp(String dni, String afp);
}
