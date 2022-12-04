package br.edu.femass.model;

import java.util.List;
import java.util.Objects;

public class Autor {
    private String nome;
    private String sobrenome;
    private String nacionalidade;
    private List<Autor> listAutores;
    private int cod = 0;

    public Autor(){
    }

    public Autor(String nome, String sobrenome, String nacionalidade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
        this.cod++;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
