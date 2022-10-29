package com.afp.cliente.repository;

import com.afp.cliente.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity,Long> {
    Optional<ClienteEntity> findByDni(String dni);
}
