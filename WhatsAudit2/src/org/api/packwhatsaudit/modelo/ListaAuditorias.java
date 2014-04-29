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
		int numeroFilas = -1;
		try {
			String consulta = "SELECT * FROM auditoria"; 
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
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
}