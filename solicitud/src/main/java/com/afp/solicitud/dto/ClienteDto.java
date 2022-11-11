package com.afp.solicitud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming()
public class ClienteDto {
    private Long clienteId;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private String afp;
    private double montoDisponible;
    private Date fechaRetiro;
    private String nroCta;
    private String usuarioRegistro;
    private Date fechaRegistro;
}
