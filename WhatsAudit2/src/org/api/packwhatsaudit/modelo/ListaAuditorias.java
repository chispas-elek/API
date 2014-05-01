package org.api.packwhatsaudit.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaAuditorias {

	//ATRIBUTOS
	private ArrayList<Auditoria> lAuditorias;

	//M�TODO CONSTRUCTOR
	public ListaAuditorias() {
		lAuditorias = new ArrayList<Auditoria>();
	}

	public ArrayList<Auditoria> getlAuditorias() {
		return lAuditorias;
	}

	//M�TODOS DEFINIDOS
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
				//Revisar �sta parte y mirar si se puede hacer que la BD autoincremente los ids
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
	
	public String obtenerNombreAuditoria(Auditoria pAudi) {
		String nombreAudit = new String();
		try {
			Conector conector = Conector.getConector();
			String consulta = "Select * FROM auditoria where idAuditoria="+pAudi.getId()+";";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				nombreAudit = rs.getString("nombreAuditoria");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreAudit;
	}
}