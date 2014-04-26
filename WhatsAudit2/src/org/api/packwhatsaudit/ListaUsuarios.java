package org.api.packwhatsaudit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaUsuarios {

	//ATRIBUTOS
	private ArrayList<Usuario> lUsuarios;

	//MÉTODO CONSTRUCTOR
	public ListaUsuarios() {
		lUsuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getlUsuarios() {
		return lUsuarios;
	}

	//MÉTODOS DEFINIDOS
	//OK
	public ArrayList<Usuario> obtenerUsuarios() {
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT * FROM usuario";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lUsuarios.add(new Usuario(rs.getInt("idUsuario"), rs.getString("nombre"), rs.getString("contraseña"), rs.getInt("tipo")));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lUsuarios;
	}

	//OK
	public int anadirUsuario(Usuario pUs) {
		Conector conector = Conector.getConector();
		int numeroFilas = -1;
		try {
			String consulta = "SELECT * FROM usuario"; 
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				numeroFilas++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		numeroFilas++;
		String inserccion = "INSERT INTO usuario (idUsuario, nombre, contraseña, tipo) VALUES (" + numeroFilas + ", '"+pUs.getNombre() +  "', '" + pUs.getContraseña() + "', " + pUs.getTipo() + ");";
		conector.execSQL(inserccion);
		return numeroFilas;
	}
}