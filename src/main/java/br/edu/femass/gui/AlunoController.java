package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.util.List;
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
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnGravar;
    @FXML
    private TableView<Aluno> tabela = new TableView<Aluno>();
    @FXML
    private TableColumn<Aluno,Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Aluno,String> colNome = new TableColumn<>();
    @FXML
    private TableColumn<Aluno,String> colEndereco = new TableColumn<>();
    @FXML
    private TableColumn<Aluno,String> colMatricula = new TableColumn<>();
    @FXML
    private TableColumn<Aluno,String> colTelefone = new TableColumn<>();
    private DaoAluno dao = new DaoAluno();
    Aluno aluno = new Aluno();
    private Boolean incluindo;

    @FXML
    private void gravar_click(ActionEvent event) {
        aluno.setNome(txtNome.getText());
        aluno.setEndereco(txtEndereco.getText());
        aluno.setTelefone(txtTelefone.getText());
        aluno.setMatricula(txtMatricula.getText());
        if (incluindo) {
            dao.inserir(aluno);
        } else {
            dao.alterar(aluno);
        }
        preencherTabela();
        editar(false);

    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);

        incluindo = true;
        preencherTabela();
        aluno = new Aluno();
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtMatricula.setText("");
        txtNome.requestFocus();
    }

    @FXML
    private void alterar_click(ActionEvent event) {
        editar(true);
        preencherTabela();
        incluindo = false;
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(aluno);
        preencherTabela();
    }

    private void editar(boolean habilitar) {
        tabela.setDisable(habilitar);
        txtNome.setDisable(!habilitar);
        txtEndereco.setDisable(!habilitar);
        txtTelefone.setDisable(!habilitar);
        txtMatricula.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
        btnAlterar.setDisable(habilitar);
        btnIncluir.setDisable(habilitar);
        btnExcluir.setDisable(habilitar);
    }

    private void preencherTabela() {
        List<Aluno> alunos = dao.buscarTodos();

        ObservableList<Aluno> data = FXCollections.observableArrayList(alunos);
        tabela.setItems(data);
    }

    private void exibirDados(){
        Aluno aluno = tabela.getSelectionModel().getSelectedItem();
        if (aluno == null) return;

        txtNome.setText(aluno.getNome());
        txtEndereco.setText(aluno.getEndereco());
        txtMatricula.setText(aluno.getMatricula());
        txtTelefone.setText(aluno.getTelefone());
    }

    @FXML
    public void tableMouseClicked(MouseEvent event){
        exibirDados();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Aluno, Long>("id")
        );

        colNome.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("nome")
        );

        colEndereco.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("endereco")
        );

        colMatricula.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("matricula")
        );

        colTelefone.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("telefone")
        );

        preencherTabela();
        editar(false);
    }
}
