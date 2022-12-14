package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class DevolucaoController implements Initializable {

    @FXML
    private Button btnGravar;
    @FXML
    private TableView<Emprestimo> tabela = new TableView<>();
    @FXML
    private TableColumn<Emprestimo, Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Exemplar, String> colExemplar = new TableColumn<>();
    @FXML
    private TableColumn<Leitor, String> colLeitor = new TableColumn<>();
    @FXML
    private TableColumn<Emprestimo, LocalDate> colData = new TableColumn<Emprestimo, LocalDate>();
    @FXML
    private TableColumn<Emprestimo, LocalDate> colPrevisao = new TableColumn<Emprestimo, LocalDate>();
    private DaoEmprestimo dao = new DaoEmprestimo();
    private Emprestimo emprestimo;
    private Exemplar exemplar;

    @FXML
    private void gravar_click(ActionEvent event){
        emprestimo = tabela.getSelectionModel().getSelectedItem();
        emprestimo.setDatadevolucao(LocalDate.now());
        exemplar = emprestimo.getExemplar();
        exemplar.setDisponivel(true);
        dao.alterar(emprestimo);
        preencherTabela();
    }

    private void preencherTabela(){
        List<Emprestimo> emprestimos = dao.buscasPendentes();
        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
        tabela.setItems(data);
        tabela.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, Long>("id")
        );

        colExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, String >("exemplar")
        );

        colLeitor.setCellValueFactory(
                new PropertyValueFactory<Leitor, String>("leitor")
        );

        colData.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, LocalDate>("dataEmprestimo")
        );

        colPrevisao.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, LocalDate>("dataPrevistaDevolucao")
        );
        preencherTabela();
    }
}
