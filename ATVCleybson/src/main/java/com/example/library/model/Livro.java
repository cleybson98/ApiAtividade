package com.example.library.model;

import jakarta.persistence.*;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro() {}

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo=titulo;}
    public String getAutor(){return autor;}
    public void setAutor(String autor){this.autor=autor;}
    public String getIsbn(){return isbn;}
    public void setIsbn(String isbn){this.isbn=isbn;}
    public int getAnoPublicacao(){return anoPublicacao;}
    public void setAnoPublicacao(int anoPublicacao){this.anoPublicacao=anoPublicacao;}
    public boolean isDisponivel(){return disponivel;}
    public void setDisponivel(boolean disponivel){this.disponivel=disponivel;}
}
