package org.api.packwhatsaudit.controlador;

public class ControladorUsuarioHistorico {

	//ATRIBUTOS
	private static ControladorUsuarioHistorico miControladorUsuarioHistorico;
	private static String nombreUsuario;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuarioHistorico() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuarioHistorico getMiControladorUsuario() {
		if (miControladorUsuarioHistorico == null) {
			miControladorUsuarioHistorico = new ControladorUsuarioHistorico();
		}
		return miControladorUsuarioHistorico;
	}

	public static String getNombreUsuario() {
		return nombreUsuario;
	}

	public static void setNombreUsuario(String nombreUsuario) {
		ControladorUsuarioHistorico.nombreUsuario = nombreUsuario;
	}

	//MÉTODOS DEFINIDOS
}
