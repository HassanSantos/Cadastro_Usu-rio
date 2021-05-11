package com.endereco.usuario.cadastro.de.endereco.de.usuario.controller;

import java.util.List;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.dto.UserDto;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.exception.CpfAlreadyRegisteredException;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.exception.EmailAlreadyRegisteredException;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.exception.UserNotFoundException;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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

    private User cadastrarUsuario;


    @PostMapping(path = "/cadastro")
    public User addUsuario(@RequestBody User user) throws UserNotFoundException, CpfAlreadyRegisteredException, EmailAlreadyRegisteredException {
        cadastrarUsuario = userService.cadastrarUsuario(user);
        return cadastrarUsuario;
    }

    @GetMapping("/endereco/usuario/{idUser}") 
    public List<Object> enderecoDoUsuario(@PathVariable int idUser) throws UserNotFoundException, CpfAlreadyRegisteredException{
        return this.userService.buscarEnderecoUsuario(idUser);
    }

    @GetMapping("/endereco/teste/{idUser}") 
    public UserDto enderecoDoUsuarioteste(@PathVariable int idUser){
        return userService.buscarEnderecoUsuarioTeste(idUser);
    }

}
