package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class autorController implements Initializable {
    
    @FXML
    private Label txtNome;
    @FXML
    private Label txtSobrenome;
    @FXML
    private Label txtNacionalidade;

    @FXML
    private void btnDeletar(ActionEvent event){
        System.out.println("deletar");
    }

    @FXML
    private void btnAlterar(ActionEvent event){
        System.out.println("alterar");
    }
    @FXML
    private void btnSalvar(ActionEvent event) {
        System.out.println("Salvar");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
