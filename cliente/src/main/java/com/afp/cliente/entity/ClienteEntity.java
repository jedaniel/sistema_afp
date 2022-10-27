package com.afp.cliente.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "CLIENTE")
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Usuario_Registro")
    private String usuarioRegistro;

    @Column(name = "Fecha_Registro")
    private Date fechaRegistro;

    @Column(name = "Usuario_modificacion")
    private String usuarioModificacion;

    @Column(name = "Fecha_Modificacion")
    private Date fechaModificacion;
}
