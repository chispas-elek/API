package org.api.packwhatsaudit.modelo;

import java.util.ArrayList;

public class GestorAuditoria {

	//ATRIBUTOS
	private static GestorAuditoria miGestorAuditoria;
	private ListaAuditorias lista;

	//MÉTODO CONSTRUCTOR
	private GestorAuditoria() {
		lista = new ListaAuditorias();
	}

	//GETTERS Y SETTERS	
	public static GestorAuditoria getGestorAuditoria() {
		if (miGestorAuditoria == null) {
			miGestorAuditoria = new GestorAuditoria();
		}

		return miGestorAuditoria;
	}

	public ListaAuditorias getListaAuditorias() {
		return lista;
	}

	//MÉTODOS DEFINIDOS
	//OK
	public ArrayList<Auditoria> obtenerAuditorias() {
		return lista.obtenerAuditoria();
	}
	
	//OK
	public void anadirAuditoria(Auditoria pAudit, ListaPreguntas pLPreg) {
		int idAudit = lista.anadirAuditoria(pAudit);
		pLPreg.anadirPreguntas(idAudit);
	}

	//OK
	public ArrayList<Pregunta> obtenerPreguntasAuditoria(int pIdAuditoria) {
		ListaPreguntas lPreguntas = new ListaPreguntas();
		return lPreguntas.obtenerPreguntasAuditoria(pIdAuditoria);
	}
	
	/**
	 * Metodo que dado una auditoria y una fecha determinada me devuelve todas las respuestas asociadas
	 * @param pIdAuditoria El identificador de la auditoria
	 * @param pFecha La fecha en la que se realizó la auditoria
	 * @return La lista de las respuestas
	 */
	
	public ArrayList<Respuesta> obtenerLasRespuestas(int pIdAuditoria, String pFecha, int pUsuario) {
		ListaRespuestas lRespuestas = new ListaRespuestas();
	    return lRespuestas.obtenerLasRespuestas(pIdAuditoria, pFecha, pUsuario);
	}
	
	/**
	 * Metodo que dado una lista de respuestas introduce los datos en la BD
	 * @param pListaR
	 */
	
	public void anadirRespuestas(ListaRespuestas pListaR) {
		pListaR.anadirRespuestaUsuario();
	}
	
	/**
	 * Éste metodo devolverá una lista de respuestas filtrada con las auditorias diferentes que ha contestado el usuario
	 * @param pUsuario Los datos del usuario actual.
	 */
	public ArrayList<Respuesta> obtenerAuditoriasUsuarioNoRepetidas(Usuario pUsuario) {
		//Obtenemos las respuestas del usuario sin repetir las auditorias, para saber a cuántas auditorias totales ha contestado.
		ListaRespuestas lasResp = new ListaRespuestas();
		return lasResp.obtenerAuditoriasUsuarioNoRepetidas(pUsuario);
	}
	
	public String obtenerNombreAuditoria(int pId) {
		ListaAuditorias lAudit = new ListaAuditorias();
		return lAudit.obtenerNombreAuditoria(pId);
	}
	
	/**
	 * Borra los datos de una auditoria solo si éxta nunca ha sido contestada
	 * 
	 * @param pIdAuditoria El identificador de la auditoria
	 */
	public void borrarAuditoria (int pIdAuditoria) {
		ListaAuditorias lAudit = new ListaAuditorias();
		lAudit.borrarAuditoria(pIdAuditoria);
	}
	
	/**
	 * Metodo que dado el id de una pregunta me devuelve su String asociado
	 * @param idPregunta El identificador de la pregunta
	 * @return El texto de la pregunta
	 */
	public String obtenerNombrePregunta (int idPregunta) {
		ListaPreguntas lPreg = new ListaPreguntas();
		return lPreg.obtenerNombrePregunta(idPregunta);
	}
}