package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;

public class I_Rellenar {

	//ATRIBUTOS
	private static I_Rellenar miIRellenar;
	private JFrame frame;

	//MÉTODO CONSTRUCTOR	
	private I_Rellenar() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Rellenar getMiIRellenar() {
		if (miIRellenar == null) {
			miIRellenar = new I_Rellenar();
		}
		return miIRellenar;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
