package com.afp.solicitud.repository;

import com.afp.solicitud.entity.SolicitudRetiroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRetiroRepository extends CrudRepository<SolicitudRetiroEntity, Long> {
    public List<SolicitudRetiroEntity> findByDniAndAfp(String dni, String afp);
}
