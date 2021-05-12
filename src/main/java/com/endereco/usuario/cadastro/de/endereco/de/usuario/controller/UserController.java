package com.endereco.usuario.cadastro.de.endereco.de.usuario.controller;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.dto.UserDto;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    EnderecoRepository enderecoRepository;


    @PostMapping(path = "/cadastro")
    public ResponseEntity<?> addUsuario(@RequestBody UserDto userDto) {
        return userService.cadastrarUsuario(userDto);
    }

    @GetMapping("/endereco/usuario/{idUser}") 
    public ResponseEntity<?> enderecoDoUsuario(@PathVariable int idUser){
        return this.userService.buscarEnderecoUsuario(idUser);
    }

}
