package org.api.packwhatsaudit;

import java.util.GregorianCalendar;

public class Respuesta {
	
	//ATRIBUTOS
	private int idRespuesta;
	private boolean respuestaUno;
	private boolean respuestaDos; 
	private boolean respuestaTres;
	private String respuestaTexto;
	private int idPregunta;
	private GregorianCalendar fecha;
	
	
	public Respuesta(int idRespuesta, boolean respuestaUno,
			boolean respuestaDos, boolean respuestaTres, String respuestaTexto,
			int idPregunta) {
		super();
		this.idRespuesta = idRespuesta;
		this.respuestaUno = respuestaUno;
		this.respuestaDos = respuestaDos;
		this.respuestaTres = respuestaTres;
		this.respuestaTexto = respuestaTexto;
		this.idPregunta = idPregunta;
		this.fecha = new GregorianCalendar();
	}
	
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public boolean isRespuestaUno() {
		return respuestaUno;
	}
	public void setRespuestaUno(boolean respuestaUno) {
		this.respuestaUno = respuestaUno;
	}
	public boolean isRespuestaDos() {
		return respuestaDos;
	}
	public void setRespuestaDos(boolean respuestaDos) {
		this.respuestaDos = respuestaDos;
	}
	public boolean isRespuestaTres() {
		return respuestaTres;
	}
	public void setRespuestaTres(boolean respuestaTres) {
		this.respuestaTres = respuestaTres;
	}
	public String getRespuestaTexto() {
		return respuestaTexto;
	}
	public void setRespuestaTexto(String respuestaTexto) {
		this.respuestaTexto = respuestaTexto;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	
}
