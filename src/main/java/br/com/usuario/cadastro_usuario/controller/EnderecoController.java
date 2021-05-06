package br.com.usuario.cadastro_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.cadastro_usuario.dto.EnderecoDto;
import br.com.usuario.cadastro_usuario.interfaces.CepService;

@RestController
public class EnderecoController {
    @Autowired
    private CepService cepService;

    @PostMapping("")
    public ResponseEntity<EnderecoDto> getCep(@RequestBody EnderecoDto endereco) {
        var cep = endereco.getCep();
        var request = cepService.buscaEnderecoPorCep(cep);
        endereco.setBairro(request.getBairro());
        endereco.setComplemento(request.getComplemento());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setUf(request.getUf());
        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }
}
