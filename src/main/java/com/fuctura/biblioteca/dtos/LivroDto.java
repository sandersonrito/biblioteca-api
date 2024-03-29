package com.fuctura.biblioteca.dtos;

import com.fuctura.biblioteca.enums.Tamanho;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.model.Livro;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LivroDto {
    private Integer id;

    @NotEmpty(message = "O campo TÍTULO é requerido.")
    private String titulo;

    @NotEmpty(message = "O campo NOME DO AUTOR é requerido.")
    private String nome_autor;

    @NotEmpty(message = "O campo TEXTO é requerido.")
    private String texto;

    private Tamanho tamanho;
    private Categoria categoria;

    public LivroDto() {

    }

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nome_autor = livro.getNome_autor();
        this.texto = livro.getTexto();
        this.tamanho = livro.getTamanho();
        this.categoria = livro.getCategoria();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
