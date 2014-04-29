package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;

public class I_Usuario_Historico {

	//ATRIBUTOS
	private I_Usuario_Historico miIUsuarioHistorico;
	private JFrame frame;

	//MÉTODO CONSTRUCTOR
	public I_Usuario_Historico() {
		initialize();
	}

	//GETTERS Y SETTERS
	public I_Usuario_Historico getMiIUsuarioHistorico() {
		if (miIUsuarioHistorico == null) {
			miIUsuarioHistorico = new I_Usuario_Historico();
		}
		return miIUsuarioHistorico;
	}

	//MÉTODOS DEFINIDOS
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}