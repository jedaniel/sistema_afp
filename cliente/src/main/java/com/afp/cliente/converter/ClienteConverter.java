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
        clienteEntity.setEstado(clienteDto.getEstado());
        clienteEntity.setNombres(clienteDto.getNombres());
        clienteEntity.setTelefono(clienteDto.getTelefono());
        clienteEntity.setFechaRegistro(clienteDto.getFechaRegistro());
        clienteEntity.setFechaModificacion(clienteDto.getFechaModificacion());
        clienteEntity.setUsuarioRegistro(clienteDto.getUsuarioRegistro());
        clienteEntity.setUsuarioModificacion(clienteDto.getUsuarioModificacion());
        return clienteEntity;
    }

    public ClienteDto convertClienteEntityToClienteDto(ClienteEntity clienteEntity) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setClienteId(clienteEntity.getClienteId());
        clienteDto.setApellidos(clienteEntity.getApellidos());
        clienteDto.setCorreo(clienteEntity.getCorreo());
        clienteDto.setDni(clienteEntity.getDni());
        clienteDto.setEstado(clienteEntity.getEstado());
        clienteDto.setNombres(clienteEntity.getNombres());
        clienteDto.setTelefono(clienteEntity.getTelefono());
        clienteDto.setFechaRegistro(clienteEntity.getFechaRegistro());
        clienteDto.setFechaModificacion(clienteEntity.getFechaModificacion());
        clienteDto.setUsuarioRegistro(clienteEntity.getUsuarioRegistro());
        clienteDto.setUsuarioModificacion(clienteEntity.getUsuarioModificacion());
        return clienteDto;
    }
}
