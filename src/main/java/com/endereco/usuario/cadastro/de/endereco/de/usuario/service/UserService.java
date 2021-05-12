package com.endereco.usuario.cadastro.de.endereco.de.usuario.service;

import java.util.List;
import java.util.Optional;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.dto.UserDto;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> cadastrarUsuario(UserDto userDto) {
        Optional<User> optSavedEmail = userRepository.findByEmail(userDto.getEmail());
        Optional<User> optSavedCpf = userRepository.findByEmail(userDto.getCpf());
        if (optSavedEmail.isPresent()) {
            return new ResponseEntity<>("E-mail já cadastrado", HttpStatus.BAD_REQUEST);
        } else if (optSavedCpf.isPresent()) {
            return new ResponseEntity<>("CPF já cadastrado", HttpStatus.BAD_REQUEST);
        }
        User user;
        user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return new ResponseEntity<>("Usuário " + userDto.getNome() + " cadastrado com sucesso ", HttpStatus.OK);
    }

    public ResponseEntity<?> buscarEnderecoUsuario(int idUser) {
        try {
            User user = userRepository.findById(idUser).get();
            List<Endereco> enderecos = enderecoRepository.findByidUser(idUser);
            UserDto userDto = new UserDto();

            userDto.setEnderecos(enderecos);
            userDto.setNome(user.getNome());
            userDto.setCpf(user.getCpf());
            userDto.setEmail(user.getEmail());
            userDto.setNascimento(user.getNascimento());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Usuário Não encontrado", HttpStatus.BAD_REQUEST);
        }

    }

}
