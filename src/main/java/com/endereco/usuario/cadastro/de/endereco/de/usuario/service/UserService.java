package com.endereco.usuario.cadastro.de.endereco.de.usuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.exception.CpfAlreadyRegisteredException;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.exception.EmailAlreadyRegisteredException;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.exception.UserNotFoundException;
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

    public User cadastrarUsuario(User usuario)throws UserNotFoundException, CpfAlreadyRegisteredException, EmailAlreadyRegisteredException  {
        verifyIfExistsCpf(usuario.getCpf());
        verifyIfExistsEmail(usuario.getEmail());
        return userRepository.save(usuario);
    }

    public List<Object> buscarEnderecoUsuario(int idUser) throws UserNotFoundException, CpfAlreadyRegisteredException {
        verifyIfExists(idUser);
        List<String> enderecoUser = new ArrayList<>();
        User user = userRepository.findById(idUser).get();
       
        enderecoUser.add(user.getNome());

        List<Endereco> endereco = enderecoRepository.findByidUser(user.getId());
        List<Object> newList = Stream.concat(enderecoUser.stream(), endereco.stream()).collect(Collectors.toList());

        return newList;
    }

    private void verifyIfExistsCpf(String cpf) throws CpfAlreadyRegisteredException {
        Optional<User> optSavedUser = userRepository.findByCpf(cpf);
        if (optSavedUser.isPresent()) {
            throw new CpfAlreadyRegisteredException(cpf);
        }
    }
    private void verifyIfExistsEmail(String email) throws EmailAlreadyRegisteredException {
        Optional<User> optSavedEmail = userRepository.findByEmail(email);
        if (optSavedEmail.isPresent()) {
            throw new EmailAlreadyRegisteredException(email);
        }
    }
    private User verifyIfExists(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public Iterable<Endereco> underecoBusca(int idUser) {
        Iterable<Endereco> endereco = enderecoRepository.findByidUser(idUser);
        return endereco;
    }

}
