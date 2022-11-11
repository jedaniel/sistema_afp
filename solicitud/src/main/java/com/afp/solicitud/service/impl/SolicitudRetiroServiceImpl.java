package com.afp.solicitud.service.impl;

import com.afp.solicitud.converter.SolicitudRetiroConverter;
import com.afp.solicitud.dto.ClienteDto;
import com.afp.solicitud.dto.ListaRetiroDto;
import com.afp.solicitud.dto.SolicitudRetiroDto;
import com.afp.solicitud.entity.ClienteEntity;
import com.afp.solicitud.entity.SolicitudRetiroEntity;
import com.afp.solicitud.exception.CustomBusinessException;
import com.afp.solicitud.exception.CustomNotFoundException;
import com.afp.solicitud.exception.ErrorModelException;
import com.afp.solicitud.repository.ClienteRepository;
import com.afp.solicitud.repository.SolicitudRetiroRepository;
import com.afp.solicitud.service.SolicitudRetiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudRetiroServiceImpl implements SolicitudRetiroService {

    @Autowired
    SolicitudRetiroRepository solicitudRetiroRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SolicitudRetiroConverter solicitudRetiroConverter;

    @Override
    public SolicitudRetiroDto registrarSolicitud(SolicitudRetiroDto solicitudRetiroDto) {
        Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findByDniAndAfp(solicitudRetiroDto.getDni(), solicitudRetiroDto.getAfp());
        if (!clienteEntityOptional.isPresent()) {
            List<ErrorModelException> errorModelExceptionList = new ArrayList<>();
            ErrorModelException errorModelException = new ErrorModelException();
            errorModelException.setCodeError("NOT_FOUND_DNI");
            errorModelException.setMensajeError("El cliente con DNI " + solicitudRetiroDto.getDni() + " no está vinculado a la AFP " + solicitudRetiroDto.getAfp());
            errorModelExceptionList.add(errorModelException);
            throw new CustomNotFoundException(errorModelExceptionList);
        }
        ClienteEntity clienteEntity = clienteEntityOptional.get();

        List<SolicitudRetiroEntity> solicitudRetiroEntityList = solicitudRetiroRepository.findByDniAndAfp(solicitudRetiroDto.getDni(),solicitudRetiroDto.getAfp());
        double sumaRetirada = 0;
        for (SolicitudRetiroEntity solicitudRetiroEntity : solicitudRetiroEntityList){
            sumaRetirada = sumaRetirada + solicitudRetiroEntity.getMontoRetiro();
        }
        clienteEntity.setMontoDisponible(clienteEntity.getMontoDisponible() - sumaRetirada);

        if(solicitudRetiroDto.getMontoRetiro()> clienteEntity.getMontoDisponible()){
            List<ErrorModelException> errorModelExceptionList = new ArrayList<>();
            ErrorModelException errorModelException = new ErrorModelException();
            errorModelException.setCodeError("MONTO_NO_DISPONIBLE");
            errorModelException.setMensajeError("No se puede registrar la solicitud. Monto mayor que el permitido");
            errorModelExceptionList.add(errorModelException);
            throw new CustomBusinessException(errorModelExceptionList);
        }
        if(solicitudRetiroDto.getMontoRetiro()< clienteEntity.getMontoDisponible()*0.5){
            List<ErrorModelException> errorModelExceptionList = new ArrayList<>();
            ErrorModelException errorModelException = new ErrorModelException();
            errorModelException.setCodeError("MONTO_NO_PERMITIDO");
            errorModelException.setMensajeError("Monto mínimo no cubierto, por favor revise el monto mínimo a retirar");
            errorModelExceptionList.add(errorModelException);
            throw new CustomBusinessException(errorModelExceptionList);
        }

        SolicitudRetiroEntity solicitudRetiroEntity = solicitudRetiroRepository.save(solicitudRetiroConverter.convertDtoToEntity(solicitudRetiroDto));
        solicitudRetiroDto = solicitudRetiroConverter.convertEntityToDto(solicitudRetiroEntity);
        return solicitudRetiroDto;
    }

    @Override
    public ListaRetiroDto listarSolicitudes(String dni, String afp) {
        ListaRetiroDto listaRetiroDto=new ListaRetiroDto();
        List<SolicitudRetiroDto> solicitudRetiroDtoList=new ArrayList<>();
        SolicitudRetiroDto solicitudRetiroDto = null;

        Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findByDniAndAfp(dni, afp);

        if(clienteEntityOptional.isPresent()){
            ClienteEntity clienteEntity = clienteEntityOptional.get();
            ClienteDto clienteDto=new ClienteDto();
            clienteDto.setDni(clienteEntity.getDni());
            clienteDto.setApellidos(clienteEntity.getApellidos());
            clienteDto.setNombres(clienteEntity.getNombres());
            clienteDto.setAfp(clienteDto.getAfp());
            clienteDto.setMontoDisponible(clienteEntity.getMontoDisponible());
            listaRetiroDto.setCliente(clienteDto);

            List<SolicitudRetiroEntity> solicitudRetiroEntityList = solicitudRetiroRepository.findByDniAndAfp(dni, afp);

            for(SolicitudRetiroEntity solicitudRetiroEntity: solicitudRetiroEntityList){
                solicitudRetiroDto = new SolicitudRetiroDto();
                solicitudRetiroDto.setId(solicitudRetiroEntity.getId());
                solicitudRetiroDto.setMontoRetiro(solicitudRetiroEntity.getMontoRetiro());
                solicitudRetiroDto.setFechaRetiro(solicitudRetiroEntity.getFechaRetiro());
                solicitudRetiroDtoList.add(solicitudRetiroDto);
            }
            listaRetiroDto.setRetiro(solicitudRetiroDtoList);
        }

        return listaRetiroDto;
    }
}
