package com.afp.solicitud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitudRetiroDto {

    private Long id;

    private String afp;

    private String dni;

    private double montoRetiro;

    private Date fechaRetiro;

}
