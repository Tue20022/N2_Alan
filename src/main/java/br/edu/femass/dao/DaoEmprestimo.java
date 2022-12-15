package br.edu.femass.dao;

import br.edu.femass.model.Emprestimo;

import java.util.List;

public class DaoEmprestimo extends Dao<Emprestimo>{
    public List<Emprestimo> buscarTodos(){return em.createQuery("select c from Emprestimo c order by id").getResultList();}
    public List<Emprestimo> buscarPendentes(){
        return em.createQuery("select c from Emprestimo c where datadevolucao=null order by id").getResultList();
    }
    public List<Emprestimo> buscarAtrasados(){
        return em.createQuery("select c from Emprestimo c where datadevolucao > dataPrevistaDevolucao order by id").getResultList();
    }
}
