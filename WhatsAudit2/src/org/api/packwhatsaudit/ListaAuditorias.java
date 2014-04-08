package org.api.packwhatsaudit;

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
	
	//MÉTODOS DEFINIDOS
	public  ArrayList<Auditoria> obtenerAuditoria() {
		try{
			Conector conector = Conector.getConector();
			String consulta = "SELECT idAuditoria, nombreAuditoria FROM auditoria";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lAuditorias.add(new Auditoria(rs.getInt(0), rs.getString(1)));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lAuditorias;
	}
	public void anadirAuditoria(Auditoria pAudit) {
		Conector conector = Conector.getConector();
		String consulta = "INSERT INTO auditoria VALUES ('"+pAudit.getNombre()+"');";
		conector.execSQL(consulta);
	}
}
