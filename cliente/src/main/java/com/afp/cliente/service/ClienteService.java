package com.afp.cliente.service;

import com.afp.cliente.dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    public ClienteDto saveClient(ClienteDto clienteDto);
    public ClienteDto updateClient(String dni);
    public List<ClienteDto> listAllClient();
    public ClienteDto listClientByDni(String dni);
    public void deleteClient(String dni);
}
