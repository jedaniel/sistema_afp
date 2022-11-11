package com.afp.solicitud.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "solicitud_retiro")
public class SolicitudRetiroEntity {
    @Id
    @Column(name = "id_solicitud")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String afp;

    private String dni;

    @Column(name = "monto_retiro")
    private double montoRetiro;

    @Column(name = "fecha_retiro")
    private Date fechaRetiro;

}
