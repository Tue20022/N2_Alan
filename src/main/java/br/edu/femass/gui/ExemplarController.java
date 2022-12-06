package br.edu.femass.gui;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExemplarController implements Initializable {
    private DaoExemplar dao = new DaoExemplar();
    private DaoLivro daoLivro = new DaoLivro();
    @FXML
    private ComboBox<Livro> cboLivro;
    @FXML
    private TableView<Exemplar> tabela= new TableView<>();
    @FXML
    private TableColumn<Exemplar,Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Exemplar,String> colTitulo = new TableColumn<>();
    @FXML
    private TableColumn<Livro,String> colLivro = new TableColumn<>();

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
        Exemplar exemplar =new Exemplar(
                    cboLivro.getSelectionModel().getSelectedItem()
        );
        dao.inserir(exemplar);
        JOptionPane.showMessageDialog(null, "Exemplar cadastrado");
        preencherTabela();
    }

    private void preencherTabela() {
        List<Exemplar> exemplares = dao.buscarTodos();

        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        tabela.setItems(data);
    }

    private void preencherCombo() {
        List<Livro> livros = daoLivro.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        cboLivro.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Exemplar, Long>("id")
        );

        colTitulo.setCellValueFactory(
                new PropertyValueFactory<Exemplar, String>("titulo")
        );

        colLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("livro")
        );

        preencherCombo();
        preencherTabela();
    }
}
