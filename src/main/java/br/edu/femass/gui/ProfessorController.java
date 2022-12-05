package br.edu.femass.gui;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfessorController implements Initializable {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtDisciplina;
    @FXML
    private TextField txtTelefone;

    private DaoProfessor dao = new DaoProfessor();

    public void btnDeletar(ActionEvent event){
        System.out.println("Deletar");
    }

    public void btnAlterar(ActionEvent event){
        System.out.println("Alterar");
    }

    public void btnInserir(ActionEvent event){
        System.out.println("Inserir");
    }

    public void btnSalvar(ActionEvent event){
        Professor professor =new Professor(
                txtNome.getText(),
                txtEndereco.getText(),
                txtTelefone.getText(),
                txtDisciplina.getText()
        );
        dao.inserir(professor);
        System.out.println(professor.getId());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
