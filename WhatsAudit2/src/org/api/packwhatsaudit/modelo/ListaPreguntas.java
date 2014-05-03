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
	
	/**
	 * Metodo que dado el id de una pregunta me devuelve su String asociado
	 * @param idPregunta El identificador de la pregunta
	 * @return El texto de la pregunta
	 */
	public String obtenerNombrePregunta (int idPregunta) {
		String pregunta = new String();
		try {
			Conector conector = Conector.getConector();
			String consulta = "Select nombrePregunta from pregunta where idPregunta="+idPregunta+";";
			ResultSet rs = conector.execSQL(consulta);
			while(rs.next()) {
				pregunta = rs.getString("nombrePregunta");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pregunta;
	}
}