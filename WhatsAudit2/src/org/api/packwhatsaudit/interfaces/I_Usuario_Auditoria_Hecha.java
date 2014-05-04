package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.api.packwhatsaudit.controlador.ControladorUsuarioAuditoriaHecha;

public class I_Usuario_Auditoria_Hecha {

	//ATRIBUTOS
	private static I_Usuario_Auditoria_Hecha miIUsuarioAuditoriaHecha;
	private static JFrame frame;
	private JScrollPane scrollPane;
	private static JTable tabla;
	private JButton botonAtras;

	//MÉTODO CONSTRUCTOR	
	private I_Usuario_Auditoria_Hecha() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Usuario_Auditoria_Hecha getMiIUsuarioAuditoriaHecha() {
		if (miIUsuarioAuditoriaHecha == null) {
			miIUsuarioAuditoriaHecha = new I_Usuario_Auditoria_Hecha();
		}
		return miIUsuarioAuditoriaHecha;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JTable getTabla() {
		return tabla;
	}
	
	public static void setTabla(JTable tabla) {
		I_Usuario_Auditoria_Hecha.tabla = tabla;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		ControladorUsuarioAuditoriaHecha.getMiControladorUsuarioAuditoriaHecha().obtenerDatos();
		
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 67, 564, 405);
		
		tabla.setFillsViewportHeight(true);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		botonAtras = new JButton("Atras");
		botonAtras.setBounds(10, 508, 89, 23);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorUsuarioAuditoriaHecha.getMiControladorUsuarioAuditoriaHecha().cancelarAuditoria();
			}
		});
						
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonAtras);
		frame.setVisible(true);
	}
}