package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AutorController implements Initializable {
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtNacionalidade;
    @FXML
    private TableView<Autor> tabela = new TableView<Autor>();
    @FXML
    private TableColumn<Autor,Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Autor,String> colNome = new TableColumn<>();
    @FXML
    private TableColumn<Autor,String> colSobrenome = new TableColumn<>();
    @FXML
    private TableColumn<Autor,String> colNacionalidade = new TableColumn<>();
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
        preencherTabela();
        System.out.println(autor.getId());
    }

    private void preencherTabela() {
        List<Autor> autores = dao.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        tabela.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Autor, Long>("id")
        );

        colNome.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nome")
        );

        colSobrenome.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("sobrenome")
        );

        colNacionalidade.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nacionalidade")
        );
        preencherTabela();
    }
}
