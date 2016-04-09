package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.sql.SQLException;
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
    	
    	//Metodo per cercare studenti iscritti ad un corso
    	if((nomeCorso!=null) && (nomeCorso.compareTo("")!=0) && (txtMatricola.getText().compareTo("")==0)  )
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

        //METODO PER CERCARE CORSI A CUI E' ISCRITTO UNO STUDENTE
    	else if(((nomeCorso==null) || (nomeCorso.compareTo("")==0)) && txtMatricola.getText().compareTo("")!=0 && txtMatricola.getText()!=null )
        {
    		
    	try{
	        	if(seg.cercaStudentePerMatricola(Integer.parseInt(txtMatricola.getText()))!=null)
	        	{
	        		List<Corso> lista = new ArrayList<Corso>(seg.corsiPerStudente(Integer.parseInt(txtMatricola.getText())));
	        		for (Corso c : lista)
	        		{
	        			visualizza+= c.getCondIns()+" "+c.getCrediti()+" "+c.getNome()+" "+c.getpD()+"\n";
	        		}
	        		txtRisultato.setText(visualizza);
	        		
	        	}
	        	else{
	        		txtRisultato.setText("Inserisci una matricola corretta");
	        	}
    		}
	    	catch(NumberFormatException e)
	    	{
	    		txtRisultato.setText("Inserisci una matricola corretta");
	
	    	}
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
    	String nomeCorso = boxCorso.getValue();
    	String matricola=txtMatricola.getText();
    	
    	
    	if((nomeCorso!=null) && (nomeCorso.compareTo("")!=0) && matricola.compareTo("")!=0 && matricola!=null )
    	{
    		//Se lo studente esiste
    		if(seg.cercaStudentePerMatricola(Integer.parseInt(matricola))!=null)
    		{
    			
	    			if(seg.iscriviStudenteACorso(Integer.parseInt(matricola),nomeCorso))
	    			{
	    				txtRisultato.setText("Lo studente "+seg.cercaStudentePerMatricola(Integer.parseInt(matricola)).getCognome()+" "+seg.cercaStudentePerMatricola(Integer.parseInt(matricola)).getNome()+" è stata aggiunto/a al corso: "+nomeCorso+"");
	    			}
	    			else
	    			{
	    				txtRisultato.setText("Lo studente risulta già iscritto a tale corso");
	    			}
    			
    			
    		}
    	}

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
