package com.afp.solicitud.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomBusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private List<ErrorModelException> errors;

    public CustomBusinessException(List<ErrorModelException> errors) {
        this.errors = errors;
    }
}
