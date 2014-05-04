package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import org.api.packwhatsaudit.interfaces.I_Administrador;
import org.api.packwhatsaudit.interfaces.I_Definicion_Auditoria;
import org.api.packwhatsaudit.interfaces.I_Login;
import org.api.packwhatsaudit.modelo.Auditoria;
import org.api.packwhatsaudit.modelo.GestorAuditoria;

public class ControladorAdministrador {
	
	//ATRIBUTOS
	private static ControladorAdministrador miControladorAdministrador;

	//MÉTODO CONSTRUCTOR
	private ControladorAdministrador() {

	}

	//GETTERS Y SETTERS
	public static ControladorAdministrador getControladorAdministrador() {
		if (miControladorAdministrador == null) {
			miControladorAdministrador = new ControladorAdministrador();
		}
		return miControladorAdministrador;
	}
	
	//MÉTODOS DEFINIDOS
	public void introducirAuditorias() {
		ArrayList<Auditoria> listaRecibe = GestorAuditoria.getGestorAuditoria().obtenerAuditorias();
		Iterator<Auditoria> itr = listaRecibe.iterator();
		while (itr.hasNext()) {
			I_Administrador.getModeloLista().addElement(itr.next().getNombre());
		}
	}
	
	public void añadirAuditoria() {
		I_Administrador.getFrame().dispose();
		I_Definicion_Auditoria.getIDefinicion_Auditoria();
	}
	
	public void volverLogin() {
		I_Administrador.getFrame().dispose();
		I_Login.getFrame().setVisible(true);
		I_Login.getTextFieldUsuario().setText("");
		I_Login.getPasswordFieldContraseña().setText("");
	}
}