package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.api.packwhatsaudit.interfaces.*;
import org.api.packwhatsaudit.modelo.*;

public class ControladorUsuario {

	//ATRIBUTOS
	private static ControladorUsuario miControladorUsuario;

	//M�TODO CONSTRUCTOR
	private ControladorUsuario() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuario getMiControladorUsuario() {
		if (miControladorUsuario == null) {
			miControladorUsuario = new ControladorUsuario();
		}
		return miControladorUsuario;
	}
	
	//M�TODOS DEFINIDOS
	public void introducirAuditorias() {
		ArrayList<Auditoria> listaRecibe = GestorAuditoria.getGestorAuditoria().obtenerAuditorias();
		Iterator<Auditoria> itr = listaRecibe.iterator();
		while (itr.hasNext()) {
			I_Usuario.getModeloLista().addElement(itr.next().getNombre());
		}
	}
	
	public void comprobarSeleccionLista() {
		if (I_Usuario.getLista().getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Selecciona un valor", "�Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} else {
			I_Usuario.getFrame().dispose();
			I_Usuario_Auditoria.getMiIRellenar();
		}
	}
}