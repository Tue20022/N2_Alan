package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import antlr.collections.List;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class autorController implements Initializable {
    
    @FXML
    private Label txtNome;
    @FXML
    private Label txtSobrenome;
    @FXML
    private Label txtNacionalidade;
    @FXML
    private Button btnSalvar;
    @FXML
    private List listAutores;
    
    
    @FXML
    private void btnSalvar(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
