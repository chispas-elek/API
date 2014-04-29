package org.api.packwhatsaudit.modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conector {

	//ATRIBUTOS
	Connection conexion = null;
	private static Conector miConector;

	//MÉTODO CONSTRUCTOR
	private Conector() {
		this.abrirBaseDatos();
	}

	//GETTERS Y SETTERS
	public static Conector getConector() {
		if(miConector == null){
			miConector = new Conector();
		}
		return miConector;
	}

	//MÉTODOS
	//abre la conexión a la base de datos
	private void abrirBaseDatos() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/whatsaudit", "root", "1234");
		} catch (Exception e) {
			System.err.println("Conexion erronea. Motivo: " + e.getMessage());
		}
	}

	//ejecuta un comando SQL
	public ResultSet execSQL(String query) {
		Statement s = null;
		ResultSet rs = null;
		try {
			s = (Statement) conexion.createStatement();
			if (query.toLowerCase().indexOf("select") == 0) {
				rs = this.query(s, query);
			} else {
				s.executeUpdate(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	//recoge datos de la base de datos	
	private ResultSet query(Statement s, String query) {
		ResultSet rs = null;
		try {
			s.executeQuery(query);
			rs = s.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}