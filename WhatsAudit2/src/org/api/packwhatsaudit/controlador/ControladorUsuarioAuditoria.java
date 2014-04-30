package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import org.api.packwhatsaudit.interfaces.I_Usuario_Auditoria;
import org.api.packwhatsaudit.modelo.GestorAuditoria;
import org.api.packwhatsaudit.modelo.Pregunta;

public class ControladorUsuarioAuditoria {

	//ATRIBUTOS
	private static ControladorUsuarioAuditoria miControladorUsuarioAuditoria;
	private static int numeroAuditoria;
	private static String nombreUsuario;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuarioAuditoria() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuarioAuditoria getMiControladorUsuarioAuditoria() {
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
	
	public static String getNombreUsuario() {
		return nombreUsuario;
	}

	public static void setNombreUsuario(String nombreUsuario) {
		ControladorUsuarioAuditoria.nombreUsuario = nombreUsuario;
	}
	
	//MÉTODOS DEFINIDOS
	public void obtenerDatos() {
		ArrayList<Pregunta> preguntas = GestorAuditoria.getGestorAuditoria().obtenerPreguntasAuditoria(numeroAuditoria);
		crearTabla(preguntas);
	}
	
	@SuppressWarnings("rawtypes")
	public void crearTabla(ArrayList<Pregunta> pPreguntas) {
		Vector<String> cabeceras = insertarCabeceras();
		Vector<Vector> datos = insertarDatos(pPreguntas);
		I_Usuario_Auditoria.setTabla(new JTable(datos, cabeceras));
	}
	
	public Vector<String> insertarCabeceras() {
		Vector<String> retorno = new Vector<String>();
		retorno.add("Número de pregunta");
		retorno.add("Pregunta");
		retorno.add("Sí");
		retorno.add("No sé");
		retorno.add("No");
		retorno.add("Observaciones");
		return retorno;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector<Vector> insertarDatos(ArrayList<Pregunta> pPreguntas) {
		Vector<Vector> retorno = new Vector<Vector>();
		Iterator<Pregunta> itr = pPreguntas.iterator();
		Vector vectorActual = null;
		Pregunta preguntaActual;
		while (itr.hasNext()) {
			preguntaActual = itr.next();
			vectorActual = new Vector();
			vectorActual.add(preguntaActual.getId());
			vectorActual.add(preguntaActual.getTexto());
			vectorActual.add("");
			vectorActual.add("");
			vectorActual.add("");
			vectorActual.add("");
			retorno.add(vectorActual);
		}
		return retorno;
	}
	
	public void guardarDatos() {
		
	}
	
	public void cancelarAuditoria() {
		
	}
}