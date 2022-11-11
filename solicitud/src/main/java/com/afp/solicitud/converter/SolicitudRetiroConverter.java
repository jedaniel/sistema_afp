package com.afp.solicitud.converter;

import com.afp.solicitud.dto.SolicitudRetiroDto;
import com.afp.solicitud.entity.SolicitudRetiroEntity;
import org.springframework.stereotype.Component;

@Component
public class SolicitudRetiroConverter {

    public SolicitudRetiroDto convertEntityToDto(SolicitudRetiroEntity solicitudRetiroEntity) {
        SolicitudRetiroDto solicitudRetiroDto = new SolicitudRetiroDto();
        solicitudRetiroDto.setId(solicitudRetiroEntity.getId());
        solicitudRetiroDto.setDni(solicitudRetiroEntity.getDni());
        solicitudRetiroDto.setAfp(solicitudRetiroEntity.getAfp());
        solicitudRetiroDto.setMontoRetiro(solicitudRetiroEntity.getMontoRetiro());
        solicitudRetiroDto.setFechaRetiro(solicitudRetiroEntity.getFechaRetiro());
        return solicitudRetiroDto;
    }

    public SolicitudRetiroEntity convertDtoToEntity(SolicitudRetiroDto solicitudRetiroDto){
        SolicitudRetiroEntity solicitudRetiroEntity=new SolicitudRetiroEntity();
        solicitudRetiroEntity.setId(solicitudRetiroDto.getId());
        solicitudRetiroEntity.setDni(solicitudRetiroDto.getDni());
        solicitudRetiroEntity.setAfp(solicitudRetiroDto.getAfp());
        solicitudRetiroEntity.setMontoRetiro(solicitudRetiroDto.getMontoRetiro());
        solicitudRetiroEntity.setFechaRetiro(solicitudRetiroDto.getFechaRetiro());
        return solicitudRetiroEntity;
    }
}
