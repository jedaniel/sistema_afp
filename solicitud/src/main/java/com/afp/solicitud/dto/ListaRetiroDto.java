package com.afp.solicitud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaRetiroDto {
    private ClienteDto cliente;
    private List<SolicitudRetiroDto> retiro;
}
