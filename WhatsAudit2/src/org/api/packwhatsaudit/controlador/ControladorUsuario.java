package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.api.packwhatsaudit.interfaces.*;
import org.api.packwhatsaudit.modelo.*;

public class ControladorUsuario {

	//ATRIBUTOS
	private static ControladorUsuario miControladorUsuario;
	private static String nombreUsuario;

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
	
	public static String getNombreUsuario() {
		return nombreUsuario;
	}

	public static void setNombreUsuario(String nombreUsuario) {
		ControladorUsuario.nombreUsuario = nombreUsuario;
	}

	//M�TODOS DEFINIDOS
	public void introducirAuditorias() {
		ArrayList<Auditoria> listaRecibe = GestorAuditoria.getGestorAuditoria().obtenerAuditorias();
		Iterator<Auditoria> itr = listaRecibe.iterator();
		while (itr.hasNext()) {
			I_Usuario.getModeloLista().addElement(itr.next().getNombre());
		}
	}
	
	public void realizarAuditoria() {
		if (I_Usuario.getLista().getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Selecciona un valor", "�Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} else {
			int numeroAuditoria = (I_Usuario.getLista().getSelectedIndex())+1;
			ControladorUsuarioAuditoria.setNumeroAuditoria(numeroAuditoria);
			ControladorUsuarioAuditoria.setNombreUsuario(nombreUsuario);
			I_Usuario_Auditoria.getMiIUsuarioAuditoria();
			I_Usuario.getFrame().dispose();
		}
	}
	
	public void abrirHistoricoUsuario() {
		I_Usuario_Historico.getMiIUsuarioHistorico();
		ControladorUsuarioHistorico.setNombreUsuario(nombreUsuario);
		I_Usuario.getFrame().dispose();
	}
}