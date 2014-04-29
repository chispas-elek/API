package org.api.packwhatsaudit.controlador;

public class ControladorUsuarioAuditoria {

	//ATRIBUTOS
	private static ControladorUsuarioAuditoria miControladorUsuarioAuditoria;
	private static int numeroAuditoria;

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

	public static int getNumeroAuditoria() {
		return numeroAuditoria;
	}

	public static void setNumeroAuditoria(int numeroAuditoria) {
		ControladorUsuarioAuditoria.numeroAuditoria = numeroAuditoria;
	}
}
