package br.edu.femass.gui;

import br.edu.femass.model.Exemplar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;

public class ExemplarController implements Initializable {
    public void btnDeletar(ActionEvent event){
        System.out.println("Deletar");
    }

    public void btnAlterar(javafx.event.ActionEvent event){
        System.out.println("Alterar");
    }

    public void btnInserir(javafx.event.ActionEvent event){
        System.out.println("Inserir");
    }

    public void btnSalvar(ActionEvent event){
        /*Exemplar Exemplar =new Exemplar(
                txtTitulo.getText(),
                tblExemplar.

        );
        dao.inserir(professor);
        System.out.println(professor.getId());*/
        System.out.println("salvar");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
