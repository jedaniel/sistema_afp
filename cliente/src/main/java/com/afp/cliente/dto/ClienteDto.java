package com.afp.cliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDto {
    private Long clienteId;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private String estado;
    private String usuarioRegistro;
    private Date fechaRegistro;
    private String usuarioModificacion;

    private Date fechaModificacion;
}
