package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import org.api.packwhatsaudit.controlador.ControladorUsuarioHistorico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Usuario_Historico {

	//ATRIBUTOS
	private static I_Usuario_Historico miIUsuarioHistorico;
	private static JFrame frame;
	private JLabel labelAuditorias;
	private JScrollPane scrollPane;
	private static JTable tabla;
	private JButton botonConsultar;

	//MÉTODO CONSTRUCTOR
	public I_Usuario_Historico() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Usuario_Historico getMiIUsuarioHistorico() {
		if (miIUsuarioHistorico == null) {
			miIUsuarioHistorico = new I_Usuario_Historico();
		}
		return miIUsuarioHistorico;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JTable getTabla() {
		return tabla;
	}

	public static void setTabla(JTable tabla) {
		I_Usuario_Historico.tabla = tabla;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		ControladorUsuarioHistorico.getMiControladorUsuario().obtenerDatos();
		
		labelAuditorias = new JLabel("Auditorias contestadas:");
		labelAuditorias.setHorizontalAlignment(SwingConstants.CENTER);
		labelAuditorias.setBounds(10, 21, 227, 14);
		
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 67, 564, 405);
		
		tabla.setFillsViewportHeight(true);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		botonConsultar = new JButton("Ver respuestas");
		botonConsultar.setBounds(258, 143, 116, 23);
		botonConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
				
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(labelAuditorias);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonConsultar);
		frame.setVisible(true);
	}
}