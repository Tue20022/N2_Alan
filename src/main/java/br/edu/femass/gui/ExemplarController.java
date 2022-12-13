package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExemplarController implements Initializable {
    private DaoExemplar dao = new DaoExemplar();
    private DaoLivro daoLivro = new DaoLivro();
    private Boolean incluindo;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private ComboBox<Livro> cboLivro;
    @FXML
    private TableView<Exemplar> tabela= new TableView<>();
    @FXML
    private TableColumn<Exemplar,Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Livro,String> colLivro = new TableColumn<>();
    private Exemplar exemplar = new Exemplar();
    private Livro livro;

    @FXML
    private void gravar_click(ActionEvent event) {
        exemplar.setLivro(cboLivro.getSelectionModel().getSelectedItem());
        livro = cboLivro.getSelectionModel().getSelectedItem();
        exemplar.setTitulo(livro.getTitulo());
        if (incluindo) {
            dao.inserir(exemplar);
        } else {
            dao.alterar(exemplar);
        }

        preencherTabela();
        editar(false);

    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        preencherCombo();
        preencherTabela();
        incluindo = true;
        exemplar = new Exemplar();
        cboLivro.requestFocus();
    }

    @FXML
    private void alterar_click(ActionEvent event) {
        exemplar = tabela.getSelectionModel().getSelectedItem();
        editar(true);
        preencherCombo();
        preencherTabela();
        incluindo = false;
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        exemplar = tabela.getSelectionModel().getSelectedItem();
        dao.apagar(exemplar);

        preencherTabela();
    }

    private void editar(boolean habilitar) {
        cboLivro.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
        btnAlterar.setDisable(habilitar);
        btnIncluir.setDisable(habilitar);
        btnExcluir.setDisable(habilitar);
    }

    private void preencherTabela() {
        List<Exemplar> exemplares = dao.buscarTodos();

        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        tabela.setItems(data);
        tabela.refresh();
    }

    private void preencherCombo() {
        List<Livro> livros = daoLivro.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        cboLivro.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Exemplar, Long>("id")
        );

        colLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("livro")
        );

        preencherCombo();
        preencherTabela();
        editar(false);
    }
}
