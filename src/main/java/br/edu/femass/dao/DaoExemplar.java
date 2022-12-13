package br.edu.femass.dao;

import br.edu.femass.model.Exemplar;

import java.util.List;

public class DaoExemplar extends Dao<Exemplar>{

    public List<Exemplar> buscarTodos(){
        return em.createQuery("select c from Exemplar c order by id").getResultList();
    }
    public List<Exemplar> buscarDisponiveis(){
        return em.createQuery("select c from Exemplar c where disponivel=true order by id").getResultList();
    }
}