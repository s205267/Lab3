package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.tdp.lab3.model.Studente;

public class StudenteDAO {
	String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";

	private int matricola;
	private String cognome;
	private String nome;
	private String cds;
	
	public Studente findStudente(int matricola)
	{
		
		try{	
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= "Select * From studente where matricola =\""+matricola+"\"";				
			ResultSet res = st.executeQuery(sql);
			
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

}
