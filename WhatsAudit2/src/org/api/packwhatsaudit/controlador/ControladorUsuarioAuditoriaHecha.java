package org.api.packwhatsaudit.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;
import org.api.packwhatsaudit.interfaces.I_Usuario_Auditoria;
import org.api.packwhatsaudit.interfaces.I_Usuario_Auditoria_Hecha;
import org.api.packwhatsaudit.interfaces.I_Usuario_Historico;
import org.api.packwhatsaudit.modelo.GestorAuditoria;
import org.api.packwhatsaudit.modelo.Respuesta;
import org.api.packwhatsaudit.modelo.Usuario;

public class ControladorUsuarioAuditoriaHecha {

	//ATRIBUTOS
	private static ControladorUsuarioAuditoriaHecha miControladorUsuarioAuditoria;
	private static int numeroAuditoria;
	private static Usuario usuario;
	private static String fecha;

	//MÉTODO CONSTRUCTOR
	private ControladorUsuarioAuditoriaHecha() {

	}

	//GETTERS Y SETTERS
	public static ControladorUsuarioAuditoriaHecha getMiControladorUsuarioAuditoriaHecha() {
		if (miControladorUsuarioAuditoria == null) {
			miControladorUsuarioAuditoria = new ControladorUsuarioAuditoriaHecha();
		}
		return miControladorUsuarioAuditoria;
	}

	public static int getNumeroAuditoria() {
		return numeroAuditoria;
	}

	public static void setNumeroAuditoria(int numeroAuditoria) {
		ControladorUsuarioAuditoriaHecha.numeroAuditoria = numeroAuditoria;
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario nombreUsuario) {
		ControladorUsuarioAuditoriaHecha.usuario = nombreUsuario;
	}
	
	public static String getFecha() {
		return fecha;
	}

	public static void setFecha(String fecha) {
		ControladorUsuarioAuditoriaHecha.fecha = fecha;
	}

	//MÉTODOS DEFINIDOS
	public void obtenerDatos() {
		ArrayList<Respuesta> respuestas = GestorAuditoria.getGestorAuditoria().obtenerLasRespuestas(numeroAuditoria, fecha, usuario.getId());
		crearTabla(respuestas);
	}
	
	@SuppressWarnings("rawtypes")
	public void crearTabla(ArrayList<Respuesta> pRespuestas) {
		Vector<String> cabeceras = insertarCabeceras();
		Vector<Vector> datos = insertarDatos(pRespuestas);
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
	public Vector<Vector> insertarDatos(ArrayList<Respuesta> pPreguntas) {
		Vector<Vector> retorno = new Vector<Vector>();
		Iterator<Respuesta> itr = pPreguntas.iterator();
		Vector vectorActual = null;
		Respuesta respuestaActual;
		while (itr.hasNext()) {
			respuestaActual = itr.next();
			vectorActual = new Vector();
			vectorActual.add(respuestaActual.getIdPregunta());
			vectorActual.add("");
			vectorActual.add(respuestaActual.isRespuestaUno());
			vectorActual.add(respuestaActual.isRespuestaDos());
			vectorActual.add(respuestaActual.isRespuestaTres());
			vectorActual.add(respuestaActual.getRespuestaTexto());
			retorno.add(vectorActual);
		}
		return retorno;
	}
	
	public void cancelarAuditoria() {
		I_Usuario_Auditoria_Hecha.getFrame().dispose();
		I_Usuario_Historico.getFrame().setVisible(true);
	}
}