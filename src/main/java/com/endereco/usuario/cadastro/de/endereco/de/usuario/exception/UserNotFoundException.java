package com.endereco.usuario.cadastro.de.endereco.de.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    public UserNotFoundException(int id) {
        super(String.format("USUÁRIO INEXISTENTE", id));
    }
}
