package org.api.packwhatsaudit;

public class Pregunta {
	private int id;
	private String texto;
	private int idAuditoria;
	
	public Pregunta(int id, String texto, int idAuditoria) {
		super();
		this.id = id;
		this.texto = texto;
		this.idAuditoria = idAuditoria;
	}

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
