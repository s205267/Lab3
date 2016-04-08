package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class CorsoDAO {
	String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";

	private String codIns;
	private int crediti;
	private String nome;
	private int pD;
	
	public List<Corso> elencoCorsi()
	{
		List<Corso> corsi = new ArrayList<Corso>();
		
		try{	
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= "Select * From corso";				
			ResultSet res = st.executeQuery(sql);
			
			while(res.next())
			{
				codIns  = res.getString("codins");
				crediti  = res.getInt("crediti");
				nome = res.getString("nome");
				pD = res.getInt("pd");
				
				Corso c = new Corso (codIns,crediti,nome,pD);
				corsi.add(c);
				
			}
			return corsi;
		}
	catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Studente> iscrittiAlCorso(String nomecorso) {
		
		List<Studente> lista=new ArrayList<Studente>();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql="Select DISTINCT S.matricola,S.cognome,S.nome,S.cds FROM studente S,corso C,iscrizione I WHERE I.codins=C.codins AND S.matricola=I.matricola AND C.nome=\""+nomecorso+"\"";
			
			ResultSet res=st.executeQuery(sql);
			
			while(res.next()){				
				lista.add(new Studente(Integer.parseInt(res.getString("matricola")),res.getString("nome"),res.getString("cognome"),res.getString("cds")));
			}
			res.close();
			conn.close();
			/*la lista può essere vuota...in tal caso devo restituire null per
			 * forza perchè è lo stesso valore che restituisco dopo il try catch
			 */
			if(lista.isEmpty())
				lista=null;
			
			return lista;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}

}
