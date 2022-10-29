package com.afp.cliente.controller;

import com.afp.cliente.dto.ClienteDto;
import com.afp.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afp")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDto> saveClient(@RequestBody ClienteDto clienteDto) {
        return new ResponseEntity<ClienteDto>(clienteService.saveClient(clienteDto), HttpStatus.CREATED);
    }

    @PutMapping("/cliente/{dni}")
    public ResponseEntity<ClienteDto> updateClient(@RequestBody ClienteDto clienteDto, @PathVariable("dni") String dni){
        return new ResponseEntity<ClienteDto>(clienteService.updateClient(clienteDto, dni),HttpStatus.OK);
    }

    @GetMapping("/cliente/{dni}")
    public ResponseEntity<ClienteDto> listClient(@PathVariable("dni") String dni) {
        return new ResponseEntity<ClienteDto>(clienteService.listClientByDni(dni), HttpStatus.OK);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteDto>> listAllClient(){
        return new ResponseEntity<List<ClienteDto>>(clienteService.listAllClient(),HttpStatus.OK);
    }

    @DeleteMapping("/cliente/{dni}")
    public ResponseEntity<Void> deleteClient(@PathVariable("dni") String dni){
        clienteService.deleteClient(dni);
        return  new ResponseEntity<>(null, HttpStatus.OK);
    }
}
