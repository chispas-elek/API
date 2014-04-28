package org.api.packwhatsaudit;

public class GestorUsuario {

	//ATRIBUTOS
	private static GestorUsuario miGestorUsuario;
	private ListaUsuarios lista;

	//MÉTODO CONSTRUCTOR
	private GestorUsuario() {
		lista = new ListaUsuarios();
	}

	//GETTERS Y SETTERS	
	public static GestorUsuario getGestorUsuario() {
		if (miGestorUsuario == null) {
			miGestorUsuario= new GestorUsuario();
		}

		return miGestorUsuario;
	}

	public ListaUsuarios getListaUsuarios() {
		return lista;
	}
	
	//MÉTODOS DEFINIDOS
	public void anadirUsuario(Usuario pUs) {
		lista.anadirUsuario(pUs);
	}
	
	public int comprobarUsuario(String pNombre, String pContraseña) {
		return lista.comprobarUsuario(pNombre, pContraseña);
	}
}