package org.api.packwhatsaudit;

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
	public ArrayList<Auditoria> obtenerAuditorias() {
		return lista.obtenerAuditoria();
	}
	
	public void anadirAuditoria(Auditoria pAudit, ListaPreguntas pLPreg) {
		lista.anadirAuditoria(pAudit);
		pLPreg.anadirPregunta(pAudit.getId());
	}

	public ArrayList<Pregunta> obtenerPreguntasAuditoria(int pIdAuditoria) {
		ListaPreguntas lPreguntas = new ListaPreguntas();
		return lPreguntas.obtenerPreguntasAuditoria(pIdAuditoria);
	}
	
	public ArrayList<Respuesta> obtenerRespuestasAuditoria(int pIdAuditoria) {
		return null;
	}
}