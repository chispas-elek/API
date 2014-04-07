package org.api.packwhatsaudit;

import java.util.ArrayList;;

public class GestorAuditoria {

//	ATRIBUTOS
	private static GestorAuditoria miGestorAuditoria;
	private ArrayList<Auditoria> listaAuditorias;
	
//	M�TODO CONSTRUCTOR
	private GestorAuditoria() {
		listaAuditorias = new ArrayList<Auditoria>();
	}
	
//	GETTERS Y SETTERS	
	public static GestorAuditoria getGestorAuditoria() {
		if (miGestorAuditoria == null) {
			miGestorAuditoria = new GestorAuditoria();
		}
		
		return miGestorAuditoria;
	}
	
	//M�TODOS DEFINIDOS
	public ArrayList<Auditoria> obtenerAuditorias() {
		
	}
}
