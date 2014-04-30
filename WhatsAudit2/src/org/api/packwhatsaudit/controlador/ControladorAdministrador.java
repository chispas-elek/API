package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.api.packwhatsaudit.interfaces.I_Administrador;
import org.api.packwhatsaudit.interfaces.I_Definicion_Auditoria;
import org.api.packwhatsaudit.interfaces.I_Usuario;
import org.api.packwhatsaudit.modelo.Auditoria;
import org.api.packwhatsaudit.modelo.GestorAuditoria;

public class ControladorAdministrador {
	
	//ATRIBUTOS
	private static ControladorAdministrador miControladorAdministrador;

	//MÉTODO CONSTRUCTOR
	private ControladorAdministrador() {

	}

	//GETTERS Y SETTERS
	public static ControladorAdministrador getMiControladorAdministrador() {
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
	
	public void comprobarSeleccionLista() {
		if (I_Usuario.getLista().getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Selecciona un valor", "¡Atención!", JOptionPane.ERROR_MESSAGE);
		} else {
			int numeroAuditoria = (I_Usuario.getLista().getSelectedIndex())+1;
			//metodo de borrar auditoria
		}
	}
	
	public void añadirAuditoria() {
		I_Administrador.getFrame().dispose();
		I_Definicion_Auditoria.getMiIDefinicion_Auditoria();
	}
}