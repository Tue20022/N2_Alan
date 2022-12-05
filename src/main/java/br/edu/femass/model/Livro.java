package br.edu.femass.model;

import javax.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Autor autor;

    public Livro(){

    }

    public Livro (String titulo, Autor autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor){
        this.autor =autor;
    }

    public long getId() {
        return id;
    }

    public void setId(long codigo) {
        this.id = codigo;
    }
}
