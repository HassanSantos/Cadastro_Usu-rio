package com.endereco.usuario.cadastro.de.endereco.de.usuario.controller;

import java.util.List;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    EnderecoRepository enderecoRepository;


    @PostMapping(path = "/cadastro")
    public String addUsuario(@RequestBody User user) {
        userService.cadastrarUsuario(user);
        return "Saved";
    }

    @GetMapping("/nome/{id}")
    public User showUser(@PathVariable int id) {
        return userService.showUsuario(id);
    }

    @GetMapping("/usuario/{nome}")
    public List<User> buscarUsuario(@PathVariable String nome){
       return userService.findByName(nome);
    }

    @GetMapping("/endereco/usuario/{idUser}")
    public List<Object> enderecoDoUsuario(@PathVariable int idUser){
        return userService.buscarEnderecoUsuario(idUser);
    }

    // @GetMapping("teste")
    // public Endereco buscar(@PathVariable int id){

    // }

}
