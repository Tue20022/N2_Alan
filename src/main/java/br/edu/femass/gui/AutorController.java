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
import javafx.scene.input.MouseEvent;

public class AutorController implements Initializable {
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtNacionalidade;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnAlterar;
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
    Autor autor = new Autor();
    private Boolean incluindo;

    @FXML
    private void gravar_click(ActionEvent event) {
        autor.setNome(txtNome.getText());
        autor.setSobrenome(txtSobrenome.getText());
        autor.setNacionalidade(txtNacionalidade.getText());
        if (incluindo) {
            dao.inserir(autor);
        } else {
            dao.alterar(autor);
        }
        preencherTabela();
        editar(false);

    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);

        incluindo = true;
        autor = new Autor();
        txtNome.setText("");
        txtSobrenome.setText("");
        txtNacionalidade.setText("");
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
        dao.apagar(autor);
        preencherTabela();
    }

    private void editar(boolean habilitar) {
        tabela.setDisable(habilitar);
        txtNome.setDisable(!habilitar);
        txtSobrenome.setDisable(!habilitar);
        txtNacionalidade.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
        btnAlterar.setDisable(habilitar);
        btnIncluir.setDisable(habilitar);
        btnExcluir.setDisable(habilitar);
    }
    private void exibirDados(){
        this.autor = tabela.getSelectionModel().getSelectedItem();

        if(autor==null) return;

        txtNome.setText(autor.getNome());
        txtSobrenome.setText(autor.getSobrenome());
        txtNacionalidade.setText(autor.getNacionalidade());
    }

    @FXML
    public void tableMouseClicked(MouseEvent event){
        exibirDados();
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
        editar(false);
    }
}
