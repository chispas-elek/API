package org.api.packwhatsaudit.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaAuditorias {

	//ATRIBUTOS
	private ArrayList<Auditoria> lAuditorias;

	//MÉTODO CONSTRUCTOR
	public ListaAuditorias() {
		lAuditorias = new ArrayList<Auditoria>();
	}

	public ArrayList<Auditoria> getlAuditorias() {
		return lAuditorias;
	}

	//MÉTODOS DEFINIDOS
	//OK
	public ArrayList<Auditoria> obtenerAuditoria() {
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT * FROM auditoria";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lAuditorias.add(new Auditoria(rs.getInt("idAuditoria"), rs.getString("nombreAuditoria")));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lAuditorias;
	}

	//OK
	public int anadirAuditoria(Auditoria pAudit) {
		Conector conector = Conector.getConector();
		int numeroFilas = 0;
		try {
			String consulta = "SELECT * FROM auditoria"; 
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				//Revisar ésta parte y mirar si se puede hacer que la BD autoincremente los ids
				numeroFilas++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		numeroFilas++;
		String inserccion = "INSERT INTO auditoria (idAuditoria, nombreAuditoria) VALUES (" + numeroFilas + ", '"+pAudit.getNombre()+"');";
		conector.execSQL(inserccion);
		return numeroFilas;
	}
	
	public String obtenerNombreAuditoria(int pId) {
		String nombreAudit = new String();
		try {
			Conector conector = Conector.getConector();
			String consulta = "Select * FROM auditoria where idAuditoria="+pId+";";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				nombreAudit = rs.getString("nombreAuditoria");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreAudit;
	}
	
	/**
	 * Borra los datos de una auditoria solo si éxta nunca ha sido contestada
	 * 
	 * @param pIdAuditoria El identificador de la auditoria
	 */
	public void borrarAuditoria (int pIdAuditoria) {
		boolean contestada = false;
		try {
			Conector conector = Conector.getConector();
			String consulta1 = "SELECT * FROM respuesta WHERE idAuditoria = "+pIdAuditoria+";";
			ResultSet rs = conector.execSQL(consulta1);
			if(rs.next()) {
				//Si entra aquí es que entonces la auditoria ya ha sido contestada por un usuario y no la vamos a borrar
				contestada = true;
			}
			if(!contestada) {
				String consulta2 = "DELETE FROM Auditoria WHERE idAuditoria="+pIdAuditoria+";"; 
				conector.execSQL(consulta2);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}