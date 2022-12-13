package br.edu.femass.dao;

import br.edu.femass.model.Leitor;

import java.util.List;

public class DaoLeitor extends Dao<Leitor>{
    public List<Leitor> buscarTodos(){
        return em.createQuery("select c from Leitor c order by id").getResultList();
    }
}
