package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class SegreteriaStudentiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> boxCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Circle tick;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button bttCerca;

    @FXML
    private Button bttIscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button bttReset;

    @FXML
    void doCerca(ActionEvent event) {

    }

    @FXML
    void doComplete(MouseEvent event) {

    }

    @FXML
    void doIscrizione(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert boxCorso != null : "fx:id=\"boxCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert tick != null : "fx:id=\"tick\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert bttCerca != null : "fx:id=\"bttCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert bttIscrivi != null : "fx:id=\"bttIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert bttReset != null : "fx:id=\"bttReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}
