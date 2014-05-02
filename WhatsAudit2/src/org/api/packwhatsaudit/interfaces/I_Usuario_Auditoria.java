package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.api.packwhatsaudit.controlador.ControladorUsuarioAuditoria;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Usuario_Auditoria {

	//ATRIBUTOS
	private static I_Usuario_Auditoria miIUsuarioAuditoria;
	private static JFrame frame;
	private JLabel labelInstrucciones;
	private JScrollPane scrollPane;
	private static JTable tabla;
	private JButton botonAceptar;
	private JButton botonCancelar;

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

	public static JFrame getFrame() {
		return frame;
	}

	public static JTable getTabla() {
		return tabla;
	}
	
	public static void setTabla(JTable tabla) {
		I_Usuario_Auditoria.tabla = tabla;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		ControladorUsuarioAuditoria.getMiControladorUsuarioAuditoria().obtenerDatos();
		
		labelInstrucciones = new JLabel("(Marcar con una X la opción deseada)");
		labelInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		labelInstrucciones.setBounds(10, 42, 564, 14);
		
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 67, 564, 405);
		
		tabla.setFillsViewportHeight(true);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		botonAceptar = new JButton("Guardar");
		botonAceptar.setBounds(10, 508, 89, 23);
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorUsuarioAuditoria.getMiControladorUsuarioAuditoria().guardarDatos();
			}
		});
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(485, 508, 89, 23);
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorUsuarioAuditoria.getMiControladorUsuarioAuditoria().cancelarAuditoria();
			}
		});
				
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(labelInstrucciones);
		frame.getContentPane().add(botonAceptar);
		frame.getContentPane().add(botonCancelar);
		frame.getContentPane().add(botonCancelar);
		frame.setVisible(true);
	}
}