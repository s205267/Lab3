package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Segreteria;
import it.polito.tdp.lab3.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class SegreteriaStudentiController {

	private Segreteria seg;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxCorso;

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
    private Label lblErrore;
    
    @FXML
    void doCerca(ActionEvent event) {
    	txtRisultato.clear();
    	lblErrore.setText("");
    	String nomeCorso = boxCorso.getValue();
    	String visualizza="";
    	if((nomeCorso!=null) && (nomeCorso.compareTo("")!=0) )
    	{
    		if(seg.cercaStudentiPerCorsi(nomeCorso)!= null)
    		{
	    		List<Studente> lista = new ArrayList<Studente>(seg.cercaStudentiPerCorsi(nomeCorso));
	    		
	    		for(Studente s:lista)
	    		{
	    			visualizza += s.toString()+"\n";
	    		}
	    		txtRisultato.setText(visualizza);
    		}
    		else
    		{
    			txtRisultato.setText("Nessuno studente in questo corso");
    		}
    	}
    	else
    	{
    		lblErrore.setText("Selezionare un corso");
    	}

    }

    @FXML
    void doComplete(MouseEvent event) {
    	txtNome.clear();
    	txtCognome.clear();
    	lblErrore.setText("");
    	try{
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	
    		Studente s = seg.cercaStudentePerMatricola(matricola);
    		if(s!=null)
    		{
    			txtCognome.setText(s.getCognome());
    			txtNome.setText(s.getNome());

    		}
    		else
    		{
    			lblErrore.setText("Lo studente selezionato non esiste");
    			return;
    		}
    	
    	}
    	catch(NumberFormatException e)
    	{
    		lblErrore.setText("Inserire una matricola nel formato numerico");
    	}
    	
    }

    @FXML
    void doIscrizione(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }
    public void setModel(Segreteria seg) {

		this.seg = seg;
		
			boxCorso.getItems().addAll(seg.nomiCorsi());
		
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
