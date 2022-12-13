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
    private Boolean disponivel;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Livro livro;

    public Exemplar(){
        this.disponivel = true;
        this.dataAquisicao = LocalDate.now();
    }

    public Exemplar(Livro livro){
        this.livro = livro;
        this.titulo = livro.getTitulo();
        this.dataAquisicao = LocalDate.now();
        this.disponivel = true;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivroPlus(Livro livro) {
        this.livro = livro;
        this.titulo = livro.getTitulo();
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return (id + " - " + titulo);
    }
}
