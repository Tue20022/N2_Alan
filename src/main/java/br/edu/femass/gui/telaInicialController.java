package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class telaInicialController implements Initializable{
    @FXML
    public void menu_Bibliotecario(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/telaBibliotecario.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Menu Bibliotecário");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void menu_Atendente(ActionEvent event){
        System.out.println("Beleza");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
}
