package org.api.packwhatsaudit.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
	/**
	 * Devuelve las respuestas de una auditoria dado su identificador y la fecha
	 * @param pIdAuditoria El identificador de la auditoria
	 * @param pFecha La fecha de realizaci�n
	 * @return Las respuestas asociadas de esa auditoria en esa fecha
	 */
	
	public ArrayList<Respuesta> obtenerLasRespuestas(int pIdAuditoria, String pFecha, int pUsuario) {
		ArrayList<Respuesta> lasResp = new ArrayList<Respuesta>();
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT * FROM respuesta WHERE idAuditoria=" + pIdAuditoria + " AND fecha='"+pFecha+"' AND idUsuario=" + pUsuario +";";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lasResp.add(new Respuesta(rs.getInt("idRespuesta"), rs.getString("respuestaUno"), rs.getString("respuestaDos"), rs.getString("respuestaTres"), rs.getString("respuestaTexto"), rs.getInt("idPregunta"),rs.getString("fecha"), rs.getInt("idUsuario"), rs.getInt("idAuditoria")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lasResp;
	}
	
	public void anadirRespuestaUsuario() {
		Conector conector = Conector.getConector();
		String fechaDeHoy = fechaDeHoy();
		Iterator<Respuesta> itr = this.getIterator();
		while(itr.hasNext()) {
			Respuesta unaRespuesta = itr.next();
			String consulta = "INSERT INTO respuesta (respuestaUno, respuestaDos, respuestaTres, respuestaTexto, idPregunta, fecha, idUsuario, idAuditoria) VALUES ('"+unaRespuesta.isRespuestaUno()+"','"+unaRespuesta.isRespuestaDos()+"','"+unaRespuesta.isRespuestaTres()+"','"+unaRespuesta.getRespuestaTexto()+"',"+unaRespuesta.getIdPregunta()+",'"+fechaDeHoy+"', "+unaRespuesta.getIdUsuario()+", "+unaRespuesta.getIdAuditoria()+");";
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
		
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Iterator<Respuesta> getIterator() {
		return lRespuestas.iterator();
	}
	
	/**
	 * Obtiene la hora actual del sistema y la transforma en formato String para adaptarla a la base de datos
	 * @return La fecha actual en String
	 */
	private String fechaDeHoy() {
		Calendar cal = GregorianCalendar.getInstance();
		return cal.getTime().toString();
	}
	
	public ArrayList<Respuesta> obtenerAuditoriasUsuarioNoRepetidas(Usuario pUsuario) {
		ArrayList<Respuesta> lasResp = new ArrayList<Respuesta>();
		try {
			Conector conector = Conector.getConector();
			String consulta = "SELECT DISTINCT idAuditoria, fecha FROM respuesta WHERE idUsuario=" + pUsuario.getId() + ";";
			ResultSet rs = conector.execSQL(consulta);
			while (rs.next()) {
				lasResp.add(new Respuesta(0, null, null, null, null, 0, rs.getString("fecha"), pUsuario.getId(), rs.getInt("idAuditoria")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lasResp;
	}
}