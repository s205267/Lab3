package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static final String jdbcURL="jdbc:mysql://localhost/iscritticorsi?user=root";
	public static Connection getConnection()
	{
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Errore nella connessione",e);
		}
	}
}
