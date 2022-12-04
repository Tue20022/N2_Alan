package br.edu.femass.gui;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class bibliotecarioController implements Initializable{

    @FXML
    private void btnAutor(ActionEvent event){
        System.out.println("autor");
    }

    @FXML
    private void btnLivro(ActionEvent event){
        System.out.println("livro");
    }

    @FXML
    private void btnExemplar(ActionEvent event){
        System.out.println("exemplar");
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
