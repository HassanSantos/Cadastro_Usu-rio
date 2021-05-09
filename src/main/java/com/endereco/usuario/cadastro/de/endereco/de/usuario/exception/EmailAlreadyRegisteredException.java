package com.endereco.usuario.cadastro.de.endereco.de.usuario.exception;

public class EmailAlreadyRegisteredException extends Exception{
    public EmailAlreadyRegisteredException(String email){
        super(String.format("E-mail já cadastrado no sistema", email));
    }
}
