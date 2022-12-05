package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AlunoController implements Initializable {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtTelefone;
    private DaoAluno dao = new DaoAluno();
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
        Aluno aluno = new Aluno(
                txtNome.getText(),
                txtEndereco.getText(),
                txtTelefone.getText(),
                txtMatricula.getText()
        );
        dao.inserir(aluno);
        System.out.println(aluno.getId());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
