package br.edu.femass.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AtendenteController implements Initializable {
    @FXML
    public void btnProfessor(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaProfessor.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Professor");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void btnAluno(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaAluno1.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Aluno");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void btnRealizarEmprestimo(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaEmprestimo.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Realizar Emprestimo");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void btnDevolverEmprestimo(ActionEvent event){
        System.out.println("Devolver Empréstimo");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
