package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.api.packwhatsaudit.interfaces.I_Usuario_Auditoria;
import org.api.packwhatsaudit.modelo.GestorAuditoria;
import org.api.packwhatsaudit.modelo.Pregunta;

public class ControladorUsuarioAuditoria {

	//ATRIBUTOS
	private static ControladorUsuarioAuditoria miControladorUsuarioAuditoria;
	private static int numeroAuditoria;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuarioAuditoria() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuarioAuditoria getMiControladorUsuario() {
		if (miControladorUsuarioAuditoria == null) {
			miControladorUsuarioAuditoria = new ControladorUsuarioAuditoria();
		}
		return miControladorUsuarioAuditoria;
	}

	public static int getNumeroAuditoria() {
		return numeroAuditoria;
	}

	public static void setNumeroAuditoria(int numeroAuditoria) {
		ControladorUsuarioAuditoria.numeroAuditoria = numeroAuditoria;
	}
	
	//MÉTODOS DEFINIDOS
	public void obtenerDatos() {
		ArrayList<Pregunta> preguntas = GestorAuditoria.getGestorAuditoria().obtenerPreguntasAuditoria(numeroAuditoria);
		crearTabla(preguntas);
	}
	
	public void crearTabla(ArrayList<Pregunta> pPreguntas) {
		String[] nombresDeColumnas = {"Número de pregunta", "Pregunta", "Sí", "No sé", "No", "Observaciones"};
		Object[][] datos = new Object[pPreguntas.size()][];
		Iterator<Pregunta> itr = pPreguntas.iterator();
		Pregunta preguntaActual;
		int i = 0;
		while(itr.hasNext()) {
			preguntaActual = itr.next();
			ButtonGroup grupoBotones = new ButtonGroup();
			JButton botonSi = new JButton();
			JButton botonNoSe = new JButton();
			JButton botonNo = new JButton();
			grupoBotones.add(botonSi);
			grupoBotones.add(botonNoSe);
			grupoBotones.add(botonNo);
			JTextField zonaObservaciones = new JTextField();
			datos[i] = (new Object[] {preguntaActual.getId(), preguntaActual.getTexto(), new Boolean(false), new Boolean(false), new Boolean(false), ""});
			i++;
		}
		I_Usuario_Auditoria.setTabla(new JTable(datos, nombresDeColumnas));
	}
}