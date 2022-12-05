package br.edu.femass.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAquisicao;
    private String titulo;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Livro livro;

    public Exemplar(){

    }

    public Exemplar(Livro livro){
        this.livro = livro;
        this.titulo = livro.getTitulo();
        this.dataAquisicao = LocalDate.now();
    }

    public Long getCodigo() {
        return this.id;
    }
    public void setCodigo(long codigo){
        this.id = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao() {
        this.dataAquisicao = LocalDate.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
