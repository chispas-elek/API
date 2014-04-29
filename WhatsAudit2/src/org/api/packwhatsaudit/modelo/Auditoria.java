package org.api.packwhatsaudit.modelo;

public class Auditoria {

	//ATRIBUTOS
	private int id;
	private String nombre;

	//MÉTODOS CONSTRUCTORES
	public Auditoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Auditoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	//GETTERS Y SETTERS	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}