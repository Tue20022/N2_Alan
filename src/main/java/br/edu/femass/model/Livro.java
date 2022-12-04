package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private static long proxNumero = 1L;
    private long codigo = 0L;
    private String titulo;
    private List<Autor> listAutor = new ArrayList<>();

    public Livro(){

    }

    public Livro (String titulo, List<Autor> listAutor){
        this.titulo = titulo;
        this.listAutor.addAll(listAutor);
        this.codigo = proxNumero ++;
        //atualizarCod();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public List<Autor> getListAutor() {
        return listAutor;
    }

    public void setListAutor(List<Autor> listAutor) {
        this.listAutor = listAutor;
    }
}
