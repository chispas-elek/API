package org.api.packwhatsaudit.modelo;


public class Respuesta {
	
	//ATRIBUTOS
	private int idRespuesta;
	private String respuestaUno;
	private String respuestaDos; 
	private String respuestaTres;
	private String respuestaTexto;
	private int idPregunta;
	private String fecha;
	private int idUsuario;
	private int idAuditoria;
	
	//M�TODO CONSTRUCTOR
	public Respuesta(int idRespuesta, String respuestaUno, String respuestaDos, String respuestaTres, String respuestaTexto, int idPregunta, String fecha, int idUsuario, int idAuditoria) {
		this.idRespuesta = idRespuesta;
		this.respuestaUno = respuestaUno;
		this.respuestaDos = respuestaDos;
		this.respuestaTres = respuestaTres;
		this.respuestaTexto = respuestaTexto;
		this.idPregunta = idPregunta;
		this.fecha = fecha;
		this.idUsuario = idUsuario;
		this.idAuditoria = idAuditoria;
	}
	
	public Respuesta(String respuestaUno, String respuestaDos,String respuestaTres, String respuestaTexto, int idPregunta, int idUsuario, int idAuditoria) {
		super();
		this.respuestaUno = respuestaUno;
		this.respuestaDos = respuestaDos;
		this.respuestaTres = respuestaTres;
		this.respuestaTexto = respuestaTexto;
		this.idPregunta = idPregunta;
		this.idUsuario = idUsuario;
		this.idAuditoria = idAuditoria;
	}

	public int getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	//GETTERS Y SETTERS
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String isRespuestaUno() {
		return respuestaUno;
	}
	public void setRespuestaUno(String respuestaUno) {
		this.respuestaUno = respuestaUno;
	}
	public String isRespuestaDos() {
		return respuestaDos;
	}
	public void setRespuestaDos(String respuestaDos) {
		this.respuestaDos = respuestaDos;
	}
	public String isRespuestaTres() {
		return respuestaTres;
	}
	public void setRespuestaTres(String respuestaTres) {
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}