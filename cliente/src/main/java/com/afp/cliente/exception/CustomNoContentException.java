package com.afp.cliente.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomNoContentException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private List<ErrorModelException> errors;

    public CustomNoContentException(List<ErrorModelException> errors) {
        this.errors = errors;
    }
}
