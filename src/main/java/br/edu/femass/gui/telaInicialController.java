package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class telaInicialController implements Initializable{
    @FXML
    public void menu_Bibliotecario(ActionEvent event){
        System.out.println("Beleza");
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
