package com.endereco.usuario.cadastro.de.endereco.de.usuario.controller;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @PostMapping(path = "/endereco")
    public Endereco addEndereco(@RequestBody Endereco endereco){
        return enderecoService.cadastrarEndereco(endereco);
    }

}
