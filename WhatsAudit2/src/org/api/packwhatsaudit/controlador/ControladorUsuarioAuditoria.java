package org.api.packwhatsaudit.controlador;

public class ControladorUsuarioAuditoria {

	//ATRIBUTOS
	private static ControladorUsuarioAuditoria miControladorUsuarioAuditoria;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuarioAuditoria() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuarioAuditoria getMiControladorUsuario() {
		if (miControladorUsuarioAuditoria == null) {
			miControladorUsuarioAuditoria = new ControladorUsuarioAuditoria();
		}
		return miControladorUsuarioAuditoria;
	}
}
