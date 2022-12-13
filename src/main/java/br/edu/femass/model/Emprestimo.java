package br.edu.femass.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDate dataEmprestimo;
    LocalDate dataPrevistaDevolucao;
    LocalDate datadevolucao;

    @ManyToOne(cascade = CascadeType.ALL)
    Exemplar exemplar;
    @ManyToOne(cascade = CascadeType.ALL)
    Leitor leitor;

    public Emprestimo(){
        dataEmprestimo = LocalDate.now();
    }

    public Emprestimo(Exemplar exemplar, Leitor leitor){
        this.leitor = leitor;
        this.exemplar = exemplar;
        this.exemplar.setDisponivel(false);
        dataEmprestimo = LocalDate.now();
        dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDatadevolucao() {
        return datadevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void setDataEmprestimo() {
        this.dataEmprestimo = LocalDate.now();
    }

    public void setDataPrevistaDevolucao() {
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(this.leitor.getPrazoMaximoDevolucao());
    }

    public void setDatadevolucao(LocalDate datadevolucao) {
        this.datadevolucao = datadevolucao;
    }
}
