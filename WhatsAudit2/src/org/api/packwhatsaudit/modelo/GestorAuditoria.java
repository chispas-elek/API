package org.api.packwhatsaudit.modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	
	public ArrayList<Respuesta> obtenerLasRespuestas(int pIdAuditoria, GregorianCalendar pFecha) {
		ListaRespuestas lRespuestas = new ListaRespuestas();
	    ArrayList<Pregunta> lPreguntas = this.obtenerPreguntasAuditoria(pIdAuditoria);
		return lRespuestas.obtenerRespuestasAuditoria(lPreguntas, pFecha);
	}
}