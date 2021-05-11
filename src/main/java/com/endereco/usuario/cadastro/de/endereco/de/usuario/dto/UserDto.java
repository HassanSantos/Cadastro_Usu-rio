package com.endereco.usuario.cadastro.de.endereco.de.usuario.dto;


import java.util.List;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;

public class UserDto {
    private String nome;
    private String email;
    private String cpf;
    private String nascimento;
    private List<Endereco> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public UserDto(String nome, String email, String cpf, String nascimento, List<Endereco> enderecos) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.enderecos = enderecos;
    }

    public UserDto(){}

}
