package org.api.packwhatsaudit.controlador;

import javax.swing.JOptionPane;
import org.api.packwhatsaudit.interfaces.I_Administrador;
import org.api.packwhatsaudit.interfaces.I_Login;
import org.api.packwhatsaudit.interfaces.I_Usuario;
import org.api.packwhatsaudit.modelo.GestorUsuario;
import org.api.packwhatsaudit.modelo.Usuario;

public class ControladorLogin {

	//ATRIBUTOS
	private static ControladorLogin miControladorLogin;

	//M�TODO CONSTRUCTOR
	private ControladorLogin() {

	}

	//GETTERS Y SETTERS
	public static ControladorLogin getControladorLogin() {
		if (miControladorLogin == null) {
			miControladorLogin = new ControladorLogin();
		}
		return miControladorLogin;
	}

	//M�TODOS DEFINIDOS
	public void comprobarDatosLogin() {
		Usuario usu = GestorUsuario.getGestorUsuario().comprobarUsuario(I_Login.getTextFieldUsuario().getText(), I_Login.getPasswordFieldContrase�a().getText());
		switch (usu.getTipo()) {
		case 0:
			I_Administrador.getIAdministrador();
			I_Administrador.getFrame().setVisible(true);
			I_Login.getFrame().dispose();
			break;
		case 1:
			I_Usuario.getIUsuario();
			I_Usuario.getFrame().setVisible(true);
			I_Login.getFrame().dispose();
			ControladorUsuario.setUsuario(usu);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos", "�Atenci�n!", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}