package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AutorController implements Initializable {
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtNacionalidade;
    private ListView<Autor> LstAutores;
    private DaoAutor dao = new DaoAutor();

    @FXML
    private void btnDeletar(ActionEvent event){
        System.out.println("deletar");
    }
    @FXML
    private void btnAlterar(ActionEvent event){
        System.out.println("alterar");
    }
    @FXML
    private void btnInserir(ActionEvent event){
        System.out.println("Inserir");
    }

    @FXML
    private void btnSalvar(ActionEvent event) {
        Autor autor = new Autor(
                txtNome.getText(),
                txtSobrenome.getText(),
                txtNacionalidade.getText()
        );
        dao.inserir(autor);
        System.out.println(autor.getId());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
