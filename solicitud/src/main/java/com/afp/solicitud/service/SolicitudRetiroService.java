package com.afp.solicitud.service;

import com.afp.solicitud.dto.ListaRetiroDto;
import com.afp.solicitud.dto.SolicitudRetiroDto;

import java.util.List;

public interface SolicitudRetiroService {
    public SolicitudRetiroDto registrarSolicitud(SolicitudRetiroDto solicitudRetiroDto);
    public ListaRetiroDto listarSolicitudes(String dni, String afp);
}
