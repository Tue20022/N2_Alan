package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LivroController implements Initializable {
    @FXML
    private TextField txtTitulo;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnGravar;
    @FXML
    private ComboBox<Autor> cboAutor;
    @FXML
    private TableView<Livro> tabela = new TableView<Livro>();
    @FXML
    private TableColumn<Livro,Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Livro,String> colTitulo = new TableColumn<>();
    private DaoLivro dao = new DaoLivro();
    private DaoAutor daoAutor = new DaoAutor();
    Livro livro = new Livro();
    private Boolean incluindo;

    @FXML
    private void gravar_click(ActionEvent event) {
        livro.setTitulo(txtTitulo.getText());
        livro.setAutor(cboAutor.getSelectionModel().getSelectedItem());
        if (incluindo) {
            dao.inserir(livro);
        } else {
            dao.alterar(livro);
        }
        preencherTabela();
        editar(false);
    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        preencherCombo();

        incluindo = true;

        livro = new Livro();
        txtTitulo.setText("");
        txtTitulo.requestFocus();
    }

    @FXML
    private void alterar_click(ActionEvent event) {
        editar(true);
        preencherCombo();
        incluindo = false;
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(livro);
        preencherTabela();
    }

    private void editar(boolean habilitar) {
        tabela.setDisable(habilitar);
        txtTitulo.setDisable(!habilitar);
        cboAutor.setDisable(!habilitar);
        tabela.setDisable(habilitar);
        btnGravar.setDisable(!habilitar);
        btnAlterar.setDisable(habilitar);
        btnIncluir.setDisable(habilitar);
        btnExcluir.setDisable(habilitar);
    }

    private void preencherCombo() {
        List<Autor> autores = daoAutor.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        cboAutor.setItems(data);
    }

    private void preencherTabela() {
        List<Livro> livros = dao.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        tabela.setItems(data);
    }

    private void exibirDadosTabela(){
        this.livro = tabela.getSelectionModel().getSelectedItem();

        if(livro==null) return;

        txtTitulo.setText(livro.getTitulo());
    }

    @FXML
    public void tableMouseClicked(MouseEvent event){
        exibirDadosTabela();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Livro, Long>("id")
        );

        colTitulo.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("titulo")
        );

        preencherCombo();
        preencherTabela();
        editar(false);
    }
}
