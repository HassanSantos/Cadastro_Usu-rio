package com.endereco.usuario.cadastro.de.endereco.de.usuario.service;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.interfaces.CepService;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CepService cepService;

    public Endereco cadastrarEndereco(Endereco endereco) {
        User user = userRepository.findById(endereco.getIdUser()).get();
        endereco.setUser(user);
        return enderecoRepository.save(consultarCep(endereco));
    }

    public Endereco consultarCep(Endereco endereco) {
        var cep = endereco.getCep();
        var request = cepService.buscaEnderecoPorCep(cep);
        endereco.setBairro(request.getBairro());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setLocalidade(request.getLocalidade());
        endereco.setUf(request.getUf());
        return endereco;
    }


}
