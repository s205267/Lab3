package it.polito.tdp.lab3.db;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class StudenteDAO {

	private int matricola;
	private String cognome;
	private String nome;
	private String cds;
	
	/**
	 * Legge da database lo {@link Studente} che possiede 
	 * la matricola data da {@code matricola} e ritorna un oggetto di tipo Studente 
	 * 
	 * @param matricola Matricola dello studente che vogliamo cercare
	 * @return Uno studente se esiste,altrimenti null
	 */
	public Studente findStudente(int matricola)
	{
		
		try{	
			Connection conn =DBConnect.getConnection();
			
			
			
			//String sql= "Select * From studente where matricola =\""+matricola+"\"";				
			String sql= "Select cognome,nome,cds From studente WHERE matricola = ?";				
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricola);
			ResultSet res = st.executeQuery();
			
			if(res.next())
			{
				cognome  = res.getString("cognome");
				nome = res.getString("nome");
				cds = res.getString("cds");
				
				Studente s = new Studente (matricola,cognome,nome,cds);
				res.close();
				conn.close();
				return s;
				
			}
			else
			{
				res.close();
				conn.close();
				return null;
			}
		}
	catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

	public List<Corso> corsiPerStudente(int matricola)
	{
		try{	
			List<Corso> listaCorsiStudente = new ArrayList<Corso>();
			Connection conn =DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql= "Select C.codins,C.crediti,C.nome,C.pd From studente S,Corso C , Iscrizione I where I.codins=C.codins AND S.matricola=I.matricola AND I.matricola =\""+matricola+"\"";				
			ResultSet res = st.executeQuery(sql);
			
			while(res.next())
			{
				String codins  = res.getString("codins");
				String nome = res.getString("nome");
				int pd = Integer.parseInt(res.getString("pd"));
				int crediti = Integer.parseInt(res.getString("crediti"));
				
				Corso c = new Corso (codins,crediti,nome,pd);
				
				listaCorsiStudente.add(c);
				
			}
			return listaCorsiStudente;
			
		}
	catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}


	public boolean iscriviStudenteACorso(int matricola, String nomeCorso)  {
		String codins="";
		try{	
			Connection conn =DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql= "Select codins from corso where nome =\""+nomeCorso+"\"";				
			ResultSet res = st.executeQuery(sql);
			
			if(res.next())
			{
				 codins  = res.getString("codins");
				 res.close();
				 st.close();
			}
			
			Statement st1 = conn.createStatement();
			String sql1="INSERT INTO `iscritticorsi`.`iscrizione` (`matricola`, `codins`)"
					 + " VALUES ('"+matricola+"', '"+codins+"')";
			if(st1.executeUpdate(sql1)==1)
			{
				return true;
			}
			else{
				return false;
			}
			
			
		}
	catch(SQLException e)
		{
		}
		return false;
		
	}


	
	

}
