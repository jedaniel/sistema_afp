package com.afp.cliente.service.impl;

import com.afp.cliente.converter.ClienteConverter;
import com.afp.cliente.dto.ClienteDto;
import com.afp.cliente.entity.ClienteEntity;
import com.afp.cliente.repository.ClienteRepository;
import com.afp.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteConverter clienteConverter;

    @Override
    public ClienteDto saveClient(ClienteDto clienteDto) {
        ClienteEntity clienteEntity;
        clienteEntity=clienteRepository.save(clienteConverter.convertClienteDtoToClienteEntity(clienteDto));
        return clienteConverter.convertClienteEntityToClienteDto(clienteEntity);
    }

    @Override
    public ClienteDto updateClient(String dni) {
        return null;
    }

    @Override
    public List<ClienteDto> listAllClient() {
        return null;
    }

    @Override
    public ClienteDto listClientByDni(String dni) {
        return null;
    }

    @Override
    public void deleteClient(String dni) {

    }
}
