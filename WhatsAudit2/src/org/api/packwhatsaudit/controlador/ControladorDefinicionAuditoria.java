package org.api.packwhatsaudit.controlador;

import javax.swing.JOptionPane;
import org.api.packwhatsaudit.interfaces.I_Administrador;
import org.api.packwhatsaudit.interfaces.I_Definicion_Auditoria;
import org.api.packwhatsaudit.modelo.Auditoria;
import org.api.packwhatsaudit.modelo.GestorAuditoria;
import org.api.packwhatsaudit.modelo.ListaPreguntas;
import org.api.packwhatsaudit.modelo.Pregunta;

public class ControladorDefinicionAuditoria {

	//ATRIBUTOS
	private static ControladorDefinicionAuditoria miControladorDefinicionAuditoria;

	//M�TODO CONSTRUCTOR
	private ControladorDefinicionAuditoria() {

	}

	//GETTERS Y SETTERS
	public static ControladorDefinicionAuditoria getMiControladorDefinicionAuditoria() {
		if (miControladorDefinicionAuditoria == null) {
			miControladorDefinicionAuditoria = new ControladorDefinicionAuditoria();
		}
		return miControladorDefinicionAuditoria;
	}

	//M�TODOS DEFINIDOS
	public void a�adirPreguntaLista() {
		if (I_Definicion_Auditoria.getTextFieldPregunta().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Introduce una pregunta", "�Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} else {
			I_Definicion_Auditoria.getModeloLista().addElement(I_Definicion_Auditoria.getTextFieldPregunta().getText());
			I_Definicion_Auditoria.getTextFieldPregunta().setText("");
		}
	}
	
	public void eliminarPreguntaLista() {
		if (I_Definicion_Auditoria.getLista().getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Selecciona un valor", "�Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} else {
			I_Definicion_Auditoria.getModeloLista().remove(I_Definicion_Auditoria.getLista().getSelectedIndex());
		}
	}
	
	public void a�adirPreguntasYAuditoria() {
		ListaPreguntas listaPreguntas = new ListaPreguntas();
		int i = 0;
		while (!I_Definicion_Auditoria.getModeloLista().isEmpty()) {
			listaPreguntas.getlPreguntas().add(new Pregunta(I_Definicion_Auditoria.getModeloLista().elementAt(i)));
			I_Definicion_Auditoria.getModeloLista().remove(i);
		}
		GestorAuditoria.getGestorAuditoria().anadirAuditoria(new Auditoria(I_Definicion_Auditoria.getTextFieldAuditoria().getText()), listaPreguntas);
		I_Definicion_Auditoria.getFrame().dispose();
		I_Administrador.getFrame().setVisible(true);
	}

	public void cancelarAuditoria() {
		I_Definicion_Auditoria.getFrame().dispose();
		I_Administrador.getFrame().setVisible(true);
	}
}