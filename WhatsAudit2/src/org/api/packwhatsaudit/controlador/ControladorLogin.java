package org.api.packwhatsaudit.controlador;

import javax.swing.JOptionPane;

import org.api.packwhatsaudit.interfaces.I_Administrador;
import org.api.packwhatsaudit.interfaces.I_Login;
import org.api.packwhatsaudit.interfaces.I_Usuario;
import org.api.packwhatsaudit.modelo.GestorUsuario;

public class ControladorLogin {

	//ATRIBUTOS
	private static ControladorLogin miControladorLogin;

	//M�TODO CONSTRUCTOR
	private ControladorLogin() {

	}

	//GETTERS Y SETTERS
	public static ControladorLogin getMiControladorLogin() {
		if (miControladorLogin == null) {
			miControladorLogin = new ControladorLogin();
		}
		return miControladorLogin;
	}

	//M�TODOS DEFINIDOS
	public void comprobarDatosLogin() {
		int tipoUsuario = GestorUsuario.getGestorUsuario().comprobarUsuario(I_Login.getTextFieldUsuario().getText(), I_Login.getPasswordFieldContrase�a().getText());
		switch (tipoUsuario) {
		case 0:
			I_Administrador.getMiIAdministrador();
			I_Login.getFrame().dispose();
			break;
		case 1:
			I_Usuario.getMiIUsuario();
			I_Login.getFrame().dispose();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos", "�Atenci�n!", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
