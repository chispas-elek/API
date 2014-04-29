package org.api.packwhatsaudit.modelo;

public class Pregunta {
	
	//ATRIBUTOS
	private int id;
	private String texto;
	private int idAuditoria;
	
	//MÉTODO CONSTRUCTOR
	public Pregunta(int id, String texto, int idAuditoria) {
		this.id = id;
		this.texto = texto;
		this.idAuditoria = idAuditoria;
	}

	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}
}