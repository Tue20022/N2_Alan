package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
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

public class EmprestimoController implements Initializable {
    @FXML
    private ComboBox<Leitor> cboLeitor;
    @FXML
    private ComboBox<Exemplar> cboExemplar;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnGravar;
    @FXML
    private TableView<Emprestimo> tabela = new TableView<Emprestimo>();
    @FXML
    private TableColumn<Emprestimo,Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Exemplar,String> colExemplar = new TableColumn<>();
    @FXML
    private TableColumn<Leitor, String> colLeitor = new TableColumn<>();
    private DaoEmprestimo dao = new DaoEmprestimo();
    private DaoExemplar daoExemplar = new DaoExemplar();
    private DaoLeitor daoLeitor = new DaoLeitor();
    Emprestimo emprestimo = new Emprestimo();
    private Boolean incluindo;
    Exemplar exemplar;

    @FXML
    private void gravar_click(ActionEvent event) {
        exemplar = cboExemplar.getSelectionModel().getSelectedItem();
        exemplar.setDisponivel(false);
        emprestimo.setExemplar(exemplar);
        emprestimo.setLeitor(cboLeitor.getSelectionModel().getSelectedItem());
        emprestimo.setDataEmprestimo();
        emprestimo.setDataPrevistaDevolucao();

        if(incluindo){
            dao.inserir(emprestimo);
        }else{
            dao.alterar(emprestimo);
        }
        preencherTabela();

        editar(false);
    }

    @FXML
    private void excluir_click(ActionEvent event){
        emprestimo = tabela.getSelectionModel().getSelectedItem();
        exemplar = emprestimo.getExemplar();
        exemplar.setDisponivel(true);

        dao.apagar(emprestimo);
        tabela.refresh();
    }

    @FXML
    private void incluir_click(ActionEvent event){
        editar(true);
        preencherComboLeitor();
        preencherComboExemplar();
        preencherTabela();
        incluindo = true;
        emprestimo = new Emprestimo();

    }

    @FXML
    private void alterar_click(ActionEvent event){
        emprestimo = tabela.getSelectionModel().getSelectedItem();
        editar(true);
        exemplar = emprestimo.getExemplar();
        exemplar.setDisponivel(true);
        preencherTabela();
        preencherComboLeitor();
        preencherComboExemplar();
        incluindo = false;
    }

    private void editar(boolean habilitar){
        cboLeitor.setDisable(!habilitar);
        cboExemplar.setDisable(!habilitar);
        btnAlterar.setDisable(habilitar);
        btnGravar.setDisable(!habilitar);
        btnExcluir.setDisable(habilitar);
        btnIncluir.setDisable(habilitar);
    }

    private void preencherTabela(){
        List<Emprestimo> emprestimos = dao.buscarTodos();

        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
        tabela.setItems(data);
        tabela.refresh();
    }

    private void preencherComboExemplar(){
        List<Exemplar> exemplares = daoExemplar.buscarDisponiveis();

        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        cboExemplar.setItems(data);
    }

    private void preencherComboLeitor(){
        List<Leitor> leitores = daoLeitor.buscarTodos();

        ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
        cboLeitor.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, Long>("id")
        );

        colLeitor.setCellValueFactory(
                new PropertyValueFactory<Leitor, String>("leitor")
        );

        colExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, String>("exemplar")
        );

        preencherComboExemplar();
        preencherComboLeitor();
        preencherTabela();
        editar(false);
    }
}
