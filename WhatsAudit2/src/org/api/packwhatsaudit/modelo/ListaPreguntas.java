package org.api.packwhatsaudit.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPreguntas {

	//ATRIBUTOS
	private ArrayList<Pregunta> lPreguntas;

	//MÉTODO CONSTRUCTOR
	public ListaPreguntas() {
		this.lPreguntas = new ArrayList<Pregunta>();
	}
	
	public ArrayList<Pregunta> getlPreguntas() {
		return lPreguntas;
	}

	//MÉTODOS DEFINIDOS
	//OK
	public ArrayList<Pregunta> obtenerPreguntasAuditoria(int pIdAuditoria) {
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT * FROM pregunta where idAuditoria=" + pIdAuditoria;
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lPreguntas.add(new Pregunta(rs.getInt("idPregunta"), rs.getString("nombrePregunta"), rs.getInt("idAuditoria")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lPreguntas;
	}
	
	//OK
	public void anadirPreguntas(int pIdAudit) {
		Conector conector = Conector.getConector();
		Iterator<Pregunta> itr = lPreguntas.iterator();
		while(itr.hasNext()) {
			Pregunta unaPregunta = itr.next();
			String consulta = "INSERT INTO pregunta (nombrePregunta, idAuditoria) VALUES ('"+unaPregunta.getTexto()+"',"+pIdAudit+");";
			conector.execSQL(consulta);
		}
	}
}