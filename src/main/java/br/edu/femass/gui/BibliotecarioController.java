package br.edu.femass.gui;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BibliotecarioController implements Initializable{

    @FXML
    private void btnAutor(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/telaAutor.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Menu Autor");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnLivro(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/telaLivro.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Livros");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnExemplar(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/telaExemplar.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Exemplares");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnLeitoresAtrasados(ActionEvent event){
        System.out.println("leiytores Atrasdos");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
