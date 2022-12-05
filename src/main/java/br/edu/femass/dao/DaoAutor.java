package br.edu.femass.dao;

import java.util.List;
import javax.persistence.Query;
import br.edu.femass.model.Autor;


public class DaoAutor extends Dao<Autor>{

    public List<Autor> buscarTodos(){
        return em.createQuery("select c from Autor c order by id").getResultList();
    }
}
