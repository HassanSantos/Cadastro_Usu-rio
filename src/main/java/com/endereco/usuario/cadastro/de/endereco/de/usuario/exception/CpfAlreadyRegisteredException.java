package com.endereco.usuario.cadastro.de.endereco.de.usuario.exception;

public class CpfAlreadyRegisteredException extends Exception {
    public CpfAlreadyRegisteredException(String cpf){
        super(String.format("E-mail já cadastrado no sistema", cpf));
    }
}
