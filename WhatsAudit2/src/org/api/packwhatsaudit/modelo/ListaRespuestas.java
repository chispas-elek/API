package org.api.packwhatsaudit.modelo;

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
	/**public ArrayList<Respuesta> obtenerRespuestasAuditoria(ArrayList<Pregunta> pListaP, GregorianCalendar pFecha) {
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
	}*/

	/*public void anadirRespuesta(int pIdAudit, int pIdPregunta) {
		Conector conector = Conector.getConector();
		Iterator<Respuesta> itr = lRespuestas.iterator();
		while(itr.hasNext()) {
			Respuesta unaRespuesta = itr.next();
			String consulta = "INSERT INTO respuesta ('respuestaUno','respuestaDos','respuestaTres','respuestraTexto','idPregunta','fecha') VALUES ('"+unaRespuesta.isRespuestaUno()+"','"+unaRespuesta.isRespuestaDos()+"','"+unaRespuesta.isRespuestaTres()+"','"+unaRespuesta.getRespuestaTexto()+"',"+pIdPregunta+",'"+unaRespuesta.getFecha().getTime()+"');";
			conector.execSQL(consulta);
		}
	}*/
	
	public void anadirRespuestaUsuario() {
		Conector conector = Conector.getConector();
		String fechaDeHoy = fechaDeHoy();
		Iterator<Respuesta> itr = this.getIterator();
		while(itr.hasNext()) {
			Respuesta unaRespuesta = itr.next();
			String consulta = "INSERT INTO respuesta ('respuestaUno','respuestaDos','respuestaTres','respuestaTexto','idPregunta','fecha', 'idUsuario', 'idAuditoria') VALUES ('"+unaRespuesta.isRespuestaUno()+"','"+unaRespuesta.isRespuestaDos()+"','"+unaRespuesta.isRespuestaTres()+"','"+unaRespuesta.getRespuestaTexto()+"',"+unaRespuesta.getIdPregunta()+",'"+fechaDeHoy+", "+unaRespuesta.getIdUsuario()+", "+unaRespuesta.getIdAuditoria()+");";
			conector.execSQL(consulta);
		}
	}
	
	/**
	 * Devuelve las respuestas realizadas por un usuario
	 * @param pUsuario
	 */
	
	public void obtenerRespuestasUsuario(Usuario pUsuario) {
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT *  FROM respuesta WHERE idUsuario=" + pUsuario.getId() + "';";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lRespuestas.add(new Respuesta(rs.getInt("idRespuesta"), rs.getString("respuestaUno"), rs.getString("respuestaDos"), rs.getString("respuestaTres"), rs.getString("respuestaTexto"), rs.getInt("idPregunta"),rs.getString("fecha"), rs.getInt("idUsuario"), rs.getInt("idAuditoria")));
			}
		
			conector.conexion.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Iterator<Respuesta> getIterator() {
		return lRespuestas.iterator();
	}
	
	private String fechaDeHoy() {
		return null;
	}
}