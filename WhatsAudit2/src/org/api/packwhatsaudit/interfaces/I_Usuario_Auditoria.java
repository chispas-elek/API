package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.api.packwhatsaudit.controlador.ControladorUsuarioAuditoria;

public class I_Usuario_Auditoria {

	//ATRIBUTOS
	private static I_Usuario_Auditoria miIUsuarioAuditoria;
	private JFrame frame;
	private JScrollPane scrollPane;
	private static JTable tabla;

	//MÉTODO CONSTRUCTOR	
	private I_Usuario_Auditoria() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Usuario_Auditoria getMiIUsuarioAuditoria() {
		if (miIUsuarioAuditoria == null) {
			miIUsuarioAuditoria = new I_Usuario_Auditoria();
		}
		return miIUsuarioAuditoria;
	}

	public static JTable getTabla() {
		return tabla;
	}
	
	public static void setTabla(JTable tabla) {
		I_Usuario_Auditoria.tabla = tabla;
	}


	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		ControladorUsuarioAuditoria.getMiControladorUsuario().obtenerDatos();
		
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 564, 461);
		
		tabla.setFillsViewportHeight(true);
		tabla.setAutoResizeMode(0);
		System.out.println(tabla.getRowCount());
				
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
	}
}