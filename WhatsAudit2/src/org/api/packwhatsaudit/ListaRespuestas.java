package org.api.packwhatsaudit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaRespuestas {

	//ATRIBUTOS
	private ArrayList<Respuesta> lRespuestas;

	//MÉTODO CONSTRUCTOR
	public ListaRespuestas() {
		this.lRespuestas = new ArrayList<Respuesta>();
	}
	
	//MÉTODOS DEFINIDOS
	public ArrayList<Respuesta> obtenerRespuestasAuditoria(int pIdAuditoria) {
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT idPregunta, nombrePregunta, idAuditoria FROM pregunta where idAuditoria=" + pIdAuditoria;
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				//lRespuestas.add(new Pregunta(rs.getInt("idPregunta"), rs.getString("nombrePregunta"), rs.getInt("idAuditoria")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lRespuestas;
	}
	
	public void anadirRespuesta(int pIdAudit, int pIdPregunta) {
		Conector conector = Conector.getConector();
		Iterator<Respuesta> itr = lRespuestas.iterator();
		while(itr.hasNext()) {
			Respuesta unaRespuesta = itr.next();
			String consulta = "INSERT INTO respuesta ('respuestaUno','respuestaDos','respuestaTres','respuestraTexto','idPregunta','fecha') VALUES ('"+unaRespuesta.isRespuestaUno()+"','"+unaRespuesta.isRespuestaDos()+"','"+unaRespuesta.isRespuestaTres()+"','"+unaRespuesta.getRespuestaTexto()+"',"+pIdPregunta+",'"+unaRespuesta.getFecha().getTime()+"');";
			conector.execSQL(consulta);
		}
	}
}
