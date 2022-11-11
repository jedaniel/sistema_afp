package com.afp.cliente.converter;

import com.afp.cliente.dto.ClienteDto;
import com.afp.cliente.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {
    public ClienteEntity convertClienteDtoToClienteEntity(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setClienteId(clienteDto.getClienteId());
        clienteEntity.setApellidos(clienteDto.getApellidos());
        clienteEntity.setCorreo(clienteDto.getCorreo());
        clienteEntity.setDni(clienteDto.getDni());
        clienteEntity.setAfp(clienteDto.getAfp());
        clienteEntity.setNombres(clienteDto.getNombres());
        clienteEntity.setTelefono(clienteDto.getTelefono());

        clienteEntity.setMontoDisponible(clienteDto.getMontoDisponible());
        clienteEntity.setFechaRetiro(clienteDto.getFechaRetiro());
        clienteEntity.setNroCta(clienteDto.getNroCta());

        clienteEntity.setFechaRegistro(clienteDto.getFechaRegistro());
        clienteEntity.setUsuarioRegistro(clienteDto.getUsuarioRegistro());
        return clienteEntity;
    }

    public ClienteDto convertClienteEntityToClienteDto(ClienteEntity clienteEntity) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setClienteId(clienteEntity.getClienteId());
        clienteDto.setApellidos(clienteEntity.getApellidos());
        clienteDto.setCorreo(clienteEntity.getCorreo());
        clienteDto.setDni(clienteEntity.getDni());
        clienteDto.setAfp(clienteEntity.getAfp());
        clienteDto.setNombres(clienteEntity.getNombres());
        clienteDto.setTelefono(clienteEntity.getTelefono());
        clienteDto.setMontoDisponible(clienteEntity.getMontoDisponible());
        clienteDto.setFechaRegistro(clienteEntity.getFechaRegistro());
        clienteDto.setUsuarioRegistro(clienteEntity.getUsuarioRegistro());
        return clienteDto;
    }
}
