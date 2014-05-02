package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.api.packwhatsaudit.interfaces.*;
import org.api.packwhatsaudit.modelo.*;

public class ControladorUsuario {

	//ATRIBUTOS
	private static ControladorUsuario miControladorUsuario;
	private static Usuario usuario;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuario() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuario getMiControladorUsuario() {
		if (miControladorUsuario == null) {
			miControladorUsuario = new ControladorUsuario();
		}
		return miControladorUsuario;
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario Usuario) {
		ControladorUsuario.usuario = Usuario;
	}

	//MÉTODOS DEFINIDOS
	public void introducirAuditorias() {
		ArrayList<Auditoria> listaRecibe = GestorAuditoria.getGestorAuditoria().obtenerAuditorias();
		Iterator<Auditoria> itr = listaRecibe.iterator();
		while (itr.hasNext()) {
			I_Usuario.getModeloLista().addElement(itr.next().getNombre());
		}
	}
	
	public void realizarAuditoria() {
		if (I_Usuario.getLista().getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Selecciona un valor", "¡Atención!", JOptionPane.ERROR_MESSAGE);
		} else {
			int numeroAuditoria = (I_Usuario.getLista().getSelectedIndex())+1;
			ControladorUsuarioAuditoria.setNumeroAuditoria(numeroAuditoria);
			ControladorUsuarioAuditoria.setUsuario(usuario);
			I_Usuario_Auditoria.getMiIUsuarioAuditoria();
			I_Usuario.getFrame().dispose();
		}
	}
	
	public void abrirHistorico() {
		ControladorUsuarioHistorico.setUsuario(usuario);
		I_Usuario_Historico.getMiIUsuarioHistorico();
		I_Usuario.getFrame().dispose();
	}
}