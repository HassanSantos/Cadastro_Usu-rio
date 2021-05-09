package com.endereco.usuario.cadastro.de.endereco.de.usuario.service;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.interfaces.CepService;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;
import com.endereco.usuario.cadastro.de.endereco.de.usuario.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CepService cepService;

    public Endereco cadastrarEndereco(Endereco endereco) {
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
