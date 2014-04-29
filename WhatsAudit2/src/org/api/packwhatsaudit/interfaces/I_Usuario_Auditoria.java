package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;

public class I_Usuario_Auditoria {

	//ATRIBUTOS
	private static I_Usuario_Auditoria miIUsuarioAuditoria;
	private JFrame frame;

	//MÉTODO CONSTRUCTOR	
	private I_Usuario_Auditoria() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Usuario_Auditoria getMiIRellenar() {
		if (miIUsuarioAuditoria == null) {
			miIUsuarioAuditoria = new I_Usuario_Auditoria();
		}
		return miIUsuarioAuditoria;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
