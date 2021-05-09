package com.endereco.usuario.cadastro.de.endereco.de.usuario.repository;

import java.util.List;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
    List<Endereco> findByidUser(int idUser);
}
