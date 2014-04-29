package org.api.packwhatsaudit.modelo;

public class Usuario {

	//ATRIBUTOS
	private int id;
	private String nombre;
	private String contraseña;
	private int tipo;
	
	//MÉTODO CONSTRUCTOR
	public Usuario(int id, String nombre, String contraseña, int tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}

	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public int getTipo() {
		return tipo;
	}
}