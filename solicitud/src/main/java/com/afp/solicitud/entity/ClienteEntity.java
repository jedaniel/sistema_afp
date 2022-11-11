package com.afp.solicitud.entity;

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

    @Column(name = "afp")
    private String afp;

    @Column(name = "monto_disponible")
    private double montoDisponible;

    @Column(name = "fecha_retiro")
    private Date fechaRetiro;

    @Column(name = "nro_cta")
    private String nroCta;

    @Column(name = "Usuario_Registro")
    private String usuarioRegistro;

    @Column(name = "Fecha_Registro")
    private Date fechaRegistro;

}
