package com.afp.cliente.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "CLIENTE")
@NoArgsConstructor
public class ClienteEntity {
    private Long clienteId;
    private String nombres;
    private String Apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private String estado;
    private String usuarioRegistro;
    private Date fechaRegistro;
    private String usuarioModificaion;
    private Date fechaModificacion;
}
