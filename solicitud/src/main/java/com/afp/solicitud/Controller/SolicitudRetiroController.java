package com.afp.solicitud.Controller;

import com.afp.solicitud.dto.ListaRetiroDto;
import com.afp.solicitud.dto.SolicitudRetiroDto;
import com.afp.solicitud.service.SolicitudRetiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afp")
public class SolicitudRetiroController {

    @Autowired
    SolicitudRetiroService solicitudRetiroService;

    @PostMapping("/solicitud")
    public ResponseEntity<SolicitudRetiroDto> registrarSolicitudRetiro(@RequestBody SolicitudRetiroDto solicitudRetiroDto){
        return new ResponseEntity<SolicitudRetiroDto>(solicitudRetiroService.registrarSolicitud(solicitudRetiroDto), HttpStatus.CREATED);
    }

    @GetMapping("/solicitud/{dni}/{afp}")
    public ResponseEntity<ListaRetiroDto> listarRetiro(@PathVariable("dni") String dni, @PathVariable("afp") String afp ){
        return new ResponseEntity<ListaRetiroDto>(solicitudRetiroService.listarSolicitudes(dni, afp), HttpStatus.OK);
    }
}
