package org.api.packwhatsaudit.controlador;

import org.api.packwhatsaudit.modelo.Usuario;

public class ControladorUsuarioHistorico {

	//ATRIBUTOS
	private static ControladorUsuarioHistorico miControladorUsuarioHistorico;
	private static Usuario usuario;

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

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario nombreUsuario) {
		ControladorUsuarioHistorico.usuario = nombreUsuario;
	}

	//MÉTODOS DEFINIDOS
}
