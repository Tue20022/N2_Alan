package br.edu.femass.model;

import java.time.LocalDate;

public class Exemplar {
    private Long codigo = 0L;
    private LocalDate dataAquisicao;
    private String titulo;
    private Livro livro;

    public Exemplar(){

    }

    public Exemplar(Livro livro){
        this.livro = livro;
        this.titulo = livro.getTitulo();
        this.dataAquisicao = LocalDate.now();
        this.codigo++;
    }

    public Long getCodigo() {
        return this.codigo;
    }
    public void setCodigo(long codigo){
        this.codigo = codigo;
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
