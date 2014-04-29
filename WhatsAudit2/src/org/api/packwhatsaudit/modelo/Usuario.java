package org.api.packwhatsaudit.modelo;

public class Usuario {

	//ATRIBUTOS
	private int id;
	private String nombre;
	private String contrase�a;
	private int tipo;
	
	//M�TODO CONSTRUCTOR
	public Usuario(int id, String nombre, String contrase�a, int tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.tipo = tipo;
	}

	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public int getTipo() {
		return tipo;
	}
}