package com.fuctura.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuctura.biblioteca.enums.Tamanho;

import javax.persistence.*;

@Entity
public class Livro {

    //É necessário colocar @Entity e o @Id unico para persistir no banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;

    @JsonIgnore
    //É necessário colocar a relação do banco antes de fazer uma compisição. Ex: Existe muitos livros
    // para uma categoria, esse comando é feito atraves de ex: @ManyToOne.
    @ManyToOne
    // apos fazer a relação é necessário fazer a integração da coluda de onde vem (no caso é o One do ManyToOne)
    // para agregar a tabela de livro.
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private Tamanho tamanho;
    //<<enumerate>> é uma especie de lista de conceitos bem definidos de um produto, por exemplo, que é colocado a parte
    // de um produto. não é colocado como um atributo na classe do produto.

    public Livro() {
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Tamanho tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
        this.tamanho = tamanho;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }


}
