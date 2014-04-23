package org.api.packwhatsaudit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class ListaRespuestas {

	//ATRIBUTOS
	private ArrayList<Respuesta> lRespuestas;

	//M�TODO CONSTRUCTOR
	public ListaRespuestas() {
		this.lRespuestas = new ArrayList<Respuesta>();
	}

	public ArrayList<Respuesta> getlRespuestas() {
		return lRespuestas;
	}

	//M�TODOS DEFINIDOS
	public ArrayList<Respuesta> obtenerRespuestasAuditoria(ArrayList<Pregunta> pListaP, GregorianCalendar pFecha) {
		try {
			Conector conector = Conector.getConector();
			Iterator<Pregunta> itr = pListaP.iterator();
			while (itr.hasNext()) {
				String consulta = "SELECT *  FROM respuesta WHERE idPregunta=" + itr.next().getId() + " AND fecha='" + pFecha + "';";
				ResultSet rs = conector.execSQL(consulta);
				while (rs.next()) {
					lRespuestas.add(new Respuesta(rs.getInt("idRespuesta"), rs.getBoolean("respuestaUno"), rs.getBoolean("respuestaDos"), rs.getBoolean("respuestaTres"), rs.getString("respuestaTexto"), rs.getInt("idPregunta")));
				}
			}
			conector.conexion.close();
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