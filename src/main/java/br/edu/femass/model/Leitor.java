package br.edu.femass.model;

import java.util.List;

public class Leitor {
    protected static long proxNumero = 1L;
    protected long codigo = 0L;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected Integer prazoMaximoDevolucao;
    protected List<Leitor> listLeitores;

    public Leitor(){
    }

    public Leitor(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(long codigo){this.codigo = codigo;}

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setPrazoMaximoDevolucao(Integer prazo) {
        this.prazoMaximoDevolucao = prazo;
    }


    public void setListLeitores(List<Leitor> listLeitores) {
        this.listLeitores.addAll(listLeitores);
    }
}
