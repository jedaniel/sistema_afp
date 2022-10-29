package com.afp.cliente.service.impl;

import com.afp.cliente.converter.ClienteConverter;
import com.afp.cliente.dto.ClienteDto;
import com.afp.cliente.entity.ClienteEntity;
import com.afp.cliente.exception.CustomBusinessException;
import com.afp.cliente.exception.CustomNotFoundException;
import com.afp.cliente.exception.ErrorModelException;
import com.afp.cliente.repository.ClienteRepository;
import com.afp.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteConverter clienteConverter;

    @Override
    public ClienteDto saveClient(ClienteDto clienteDto) {
        ClienteEntity clienteEntity;
        Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findByDni(clienteDto.getDni());
        if(clienteEntityOptional.isPresent()){
            List<ErrorModelException> errorModelExceptionList=new ArrayList<>();
            ErrorModelException errorModelException=new ErrorModelException();
            errorModelException.setCodeError("EXIST_DNI");
            errorModelException.setMensajeError("Existe un cliente registrado con el DNI " + clienteDto.getDni());
            errorModelExceptionList.add(errorModelException);
            throw new CustomBusinessException(errorModelExceptionList);
        }
        clienteEntity=clienteRepository.save(clienteConverter.convertClienteDtoToClienteEntity(clienteDto));
        return clienteConverter.convertClienteEntityToClienteDto(clienteEntity);
    }

    @Override
    public ClienteDto updateClient(ClienteDto clienteDto, String dni) {
        ClienteEntity clienteEntity;
        Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findByDni(dni);
        if(!clienteEntityOptional.isPresent()){
            List<ErrorModelException> errorModelExceptionList=new ArrayList<>();
            ErrorModelException errorModelException=new ErrorModelException();
            errorModelException.setCodeError("NOT_FOUND_DNI");
            errorModelException.setMensajeError("No existe un cliente registrado con el DNI " + clienteDto.getDni());
            errorModelExceptionList.add(errorModelException);
            throw new CustomBusinessException(errorModelExceptionList);
        }
        clienteEntity = clienteEntityOptional.get();
        clienteEntity.setNombres(clienteDto.getNombres());
        clienteEntity.setEstado(clienteDto.getEstado());
        clienteEntity.setTelefono(clienteDto.getTelefono());
        clienteEntity.setCorreo(clienteDto.getCorreo());
        clienteEntity.setApellidos(clienteDto.getApellidos());
        clienteEntity.setUsuarioModificacion(clienteDto.getUsuarioModificacion());
        clienteEntity.setFechaModificacion(clienteDto.getFechaModificacion());
        clienteEntity=clienteRepository.save(clienteEntity);
        return clienteConverter.convertClienteEntityToClienteDto(clienteEntity);
    }

    @Override
    public List<ClienteDto> listAllClient() {
        List<ClienteEntity> clienteEntityList = (List<ClienteEntity>) clienteRepository.findAll();
        List<ClienteDto> clienteDtoList = new ArrayList<>();
        for (ClienteEntity clienteEntity: clienteEntityList){
            ClienteDto clienteDto = clienteConverter.convertClienteEntityToClienteDto(clienteEntity);
            clienteDtoList.add(clienteDto);
        }
        return clienteDtoList;
    }

    @Override
    public ClienteDto listClientByDni(String dni) {
        Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findByDni(dni);
        if(!clienteEntityOptional.isPresent()){
            List<ErrorModelException> errorModelExceptionList=new ArrayList<>();
            ErrorModelException errorModelException=new ErrorModelException();
            errorModelException.setCodeError("NOT_FOUND_DNI");
            errorModelException.setMensajeError("No existe el cliente con el DNI " + dni);
            errorModelExceptionList.add(errorModelException);
            throw new CustomNotFoundException(errorModelExceptionList);
        }
        ClienteEntity clienteEntity=clienteEntityOptional.get();
        return clienteConverter.convertClienteEntityToClienteDto(clienteEntity);
    }

    @Override
    public void deleteClient(String dni) {
        Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findByDni(dni);
        if(!clienteEntityOptional.isPresent()){
            List<ErrorModelException> errorModelExceptionList=new ArrayList<>();
            ErrorModelException errorModelException=new ErrorModelException();
            errorModelException.setCodeError("NOT_FOUND_DNI");
            errorModelException.setMensajeError("No existe el cliente con el DNI " + dni);
            errorModelExceptionList.add(errorModelException);
            throw new CustomNotFoundException(errorModelExceptionList);
        }
        ClienteEntity clienteEntity=clienteEntityOptional.get();
        clienteRepository.deleteById(clienteEntity.getClienteId());
    }
}
