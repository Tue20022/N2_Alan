package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Professor extends Leitor {
    private String disciplina;

    public Professor() {
        setPrazoMaximoDevolucao(30);
    }

    public Professor(String nome, String endereco, String telefone, String disciplina) {
        super(nome, endereco, telefone);
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return (this.id + " - " + this.nome + " - " + this.disciplina);
    }
}
