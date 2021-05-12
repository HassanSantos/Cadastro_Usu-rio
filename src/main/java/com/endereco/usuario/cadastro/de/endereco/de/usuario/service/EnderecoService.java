package com.endereco.usuario.cadastro.de.endereco.de.usuario.service;

import java.util.Optional;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.dto.EnderecoDto;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.interfaces.CepService;
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
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CepService cepService;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> cadastrarEndereco(EnderecoDto enderecoDto) {
        Optional<User> optSaveEndereco = userRepository.findById(enderecoDto.getIdUser());
        if (optSaveEndereco.isEmpty()) {
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.BAD_REQUEST);
        }
        consultarCep(enderecoDto);
        Endereco endereco = new Endereco();
        endereco = modelMapper.map(enderecoDto, Endereco.class);
        enderecoRepository.save(endereco);
        return new ResponseEntity<>("Endereço cadastrado com sucesso", HttpStatus.OK);
    }

    public EnderecoDto consultarCep(EnderecoDto enderecoDto) {
        var cep = enderecoDto.getCep();
        var request = cepService.buscaEnderecoPorCep(cep);
        enderecoDto.setBairro(request.getBairro());
        enderecoDto.setLogradouro(request.getLogradouro());
        enderecoDto.setLocalidade(request.getLocalidade());
        enderecoDto.setUf(request.getUf());
        return enderecoDto;
    }


}
