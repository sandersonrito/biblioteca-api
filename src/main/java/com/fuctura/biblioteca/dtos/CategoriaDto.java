package com.fuctura.biblioteca.dtos;


import com.fuctura.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;


//DTO significa objeto transferência de dados

public class CategoriaDto {

    private Integer id;
    private String nome;
    private String descricao;


    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

    }

    public CategoriaDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
