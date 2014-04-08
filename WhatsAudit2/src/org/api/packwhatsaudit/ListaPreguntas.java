package org.api.packwhatsaudit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaPreguntas {

	//ATRIBUTOS
	private ArrayList<Pregunta> lPreguntas;

	//MÉTODO CONSTRUCTOR
	public ListaPreguntas() {
		this.lPreguntas = new ArrayList<Pregunta>();
	}
	
	//MÉTODOS DEFINIDOS
	public ArrayList<Pregunta> obtenerPreguntasAuditoria(int pIdAuditoria) {
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT idPregunta, nombrePregunta, idAuditoria FROM pregunta where idAuditoria=" + pIdAuditoria;
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lPreguntas.add(new Pregunta(rs.getInt("idPregunta"), rs.getString("nombrePregunta"), rs.getInt("idAuditoria")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lPreguntas;
	}
	
	public void anadirPregunta(Pregunta pPregunta, Auditoria pAudit) {
		Conector conector = Conector.getConector();
		String consulta = "INSERT INTO pregunta VALUES ('"+pPregunta.getTexto()+"',"+pAudit.getId()+");";
		conector.execSQL(consulta);
	}
	
	
}