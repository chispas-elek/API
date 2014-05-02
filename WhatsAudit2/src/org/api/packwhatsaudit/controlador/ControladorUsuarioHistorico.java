package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;

import org.api.packwhatsaudit.interfaces.I_Usuario_Auditoria;
import org.api.packwhatsaudit.interfaces.I_Usuario_Historico;
import org.api.packwhatsaudit.modelo.GestorAuditoria;
import org.api.packwhatsaudit.modelo.Respuesta;
import org.api.packwhatsaudit.modelo.Usuario;

public class ControladorUsuarioHistorico {

	//ATRIBUTOS
	private static ControladorUsuarioHistorico miControladorUsuarioHistorico;
	private static Usuario usuario;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuarioHistorico() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuarioHistorico getMiControladorUsuario() {
		if (miControladorUsuarioHistorico == null) {
			miControladorUsuarioHistorico = new ControladorUsuarioHistorico();
		}
		return miControladorUsuarioHistorico;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario nombreUsuario) {
		ControladorUsuarioHistorico.usuario = nombreUsuario;
	}

	//MÉTODOS DEFINIDOS
	public void obtenerDatos() {
		ArrayList<Respuesta> respuestas = GestorAuditoria.getGestorAuditoria().obtenerAuditoriasUsuarioNoRepetidas(usuario);
		System.out.println(respuestas.size());
		crearTabla(respuestas);
	}
	
	@SuppressWarnings("rawtypes")
	public void crearTabla(ArrayList<Respuesta> pRespuestas) {
		Vector<String> cabeceras = insertarCabeceras();
		Vector<Vector> datos = insertarDatos(pRespuestas);
		I_Usuario_Historico.setTabla(new JTable(datos, cabeceras));
	}
	
	public Vector<String> insertarCabeceras() {
		Vector<String> retorno = new Vector<String>();
		retorno.add("Número de la auditoria");
		retorno.add("Fecha");
		return retorno;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector<Vector> insertarDatos(ArrayList<Respuesta> pRespuestas) {
		Vector<Vector> retorno = new Vector<Vector>();
		Iterator<Respuesta> itr = pRespuestas.iterator();
		Vector vectorActual = null;
		Respuesta respuestaActual;
		while (itr.hasNext()) {
			respuestaActual = itr.next();
			vectorActual = new Vector();
			vectorActual.add(GestorAuditoria.getGestorAuditoria().obtenerNombreAuditoria(respuestaActual.getIdAuditoria()));
			vectorActual.add(respuestaActual.getFecha());
			retorno.add(vectorActual);
		}
		return retorno;
	}
}