package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class EmprestimosAtrasadosController implements Initializable {
    @FXML
    private TableView<Emprestimo> tabela = new TableView<>();
    @FXML
    private TableColumn<Emprestimo, Long> colId = new TableColumn<>();
    @FXML
    private TableColumn<Exemplar, String> colExemplar = new TableColumn<>();
    @FXML
    private TableColumn<Leitor, String> colLeitor = new TableColumn<>();
    @FXML
    private TableColumn<Emprestimo, LocalDate> colData = new TableColumn<>();
    @FXML
    private TableColumn<Emprestimo, LocalDate> colPrevisao = new TableColumn<>();
    private DaoEmprestimo dao = new DaoEmprestimo();

    private void preencherTabela(){
        List<Emprestimo> emprestimos = dao.buscarAtrasados();

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
