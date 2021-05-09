package com.endereco.usuario.cadastro.de.endereco.de.usuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public User showUsuario(int id){
        return userRepository.findById(id).get();
    }

    public User cadastrarUsuario(User usuario){
        return userRepository.save(usuario);
    }

    public List<User> findByName(String nome){
        return userRepository.findByNome(nome);
    }

    public List<Object> buscarEnderecoUsuario(int idUser){
        List<String> enderecoUser = new ArrayList<>();
        User user = userRepository.findById(idUser).get();
        String nome = user.getNome();
        enderecoUser.add(nome);

        List<Endereco> endereco = enderecoRepository.findByidUser(user.getId());
        List<Object> newList = Stream.concat(enderecoUser.stream(), endereco.stream())
                             .collect(Collectors.toList());

        return newList;

    }

    public Iterable<Endereco> underecoBusca(int idUser){
        Iterable<Endereco> endereco = enderecoRepository.findByidUser(idUser);
        return endereco;
    }
}
