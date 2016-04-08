package it.polito.tdp.lab3.model;

import java.util.*;

import it.polito.tdp.lab3.db.CorsoDAO;
import it.polito.tdp.lab3.db.StudenteDAO;

public class Segreteria {

	public List<String> nomiCorsi(){
		List<String> nomi =new  ArrayList<String>();
		CorsoDAO dao = new CorsoDAO();
		nomi.add("");
		for(Corso c : dao.elencoCorsi()){
			nomi.add(c.getNome());
		}
		
		return nomi;
	}
	
	public Studente cercaStudentePerMatricola(int matricola)
	{
		StudenteDAO dao= new StudenteDAO();
		return dao.findStudente(matricola);
		
	}
	public List<Studente> cercaStudentiPerCorsi(String nomeCorso)
	{
		CorsoDAO dao= new CorsoDAO();
		return dao.iscrittiAlCorso(nomeCorso);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
