package org.api.packwhatsaudit.controlador;

import org.api.packwhatsaudit.interfaces.I_Administrador;
import org.api.packwhatsaudit.interfaces.I_Definicion_Auditoria;

public class ControladorDefinicionAuditoria {

	//ATRIBUTOS
	private static ControladorDefinicionAuditoria miControladorDefinicionAuditoria;

	//MÉTODO CONSTRUCTOR
	private ControladorDefinicionAuditoria() {

	}

	//GETTERS Y SETTERS
	public static ControladorDefinicionAuditoria getMiControladorDefinicionAuditoria() {
		if (miControladorDefinicionAuditoria == null) {
			miControladorDefinicionAuditoria = new ControladorDefinicionAuditoria();
		}
		return miControladorDefinicionAuditoria;
	}

	//MÉTODOS DEFINIDOS
	public void cancelarAuditoria() {
		I_Definicion_Auditoria.getFrame().dispose();
		I_Administrador.getFrame().setVisible(true);
	}
}