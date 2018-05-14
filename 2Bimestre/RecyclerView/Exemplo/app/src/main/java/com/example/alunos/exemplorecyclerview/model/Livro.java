package com.example.alunos.exemplorecyclerview.model;

public class Livro {
    private String titulo;
    private String autor;
    private String descricao;

    public Livro(String t, String a, String d){
        this.titulo = t;
        this.autor = a;
        this.descricao = d;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
