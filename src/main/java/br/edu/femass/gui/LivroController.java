package br.edu.femass.gui;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LivroController implements Initializable {
    @FXML
    private TextField txtTitulo;
    @FXML
    private ComboBox<Autor> cboAutor;
    private DaoLivro dao = new DaoLivro();

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
        Livro livro = new Livro(
                txtTitulo.getText(),
                cboAutor.getValue()
        );
        dao.inserir(livro);
        System.out.println(livro.getId());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
