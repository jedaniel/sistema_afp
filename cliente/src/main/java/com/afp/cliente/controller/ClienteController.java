package com.afp.cliente.controller;

import com.afp.cliente.dto.ClienteDto;
import com.afp.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/afp")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDto> saveClient(@RequestBody ClienteDto clienteDto) {
        return new ResponseEntity<ClienteDto>(clienteService.saveClient(clienteDto), HttpStatus.CREATED);
    }
}
