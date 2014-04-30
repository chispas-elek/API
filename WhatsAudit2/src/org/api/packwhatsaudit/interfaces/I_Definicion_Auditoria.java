package org.api.packwhatsaudit.interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import org.api.packwhatsaudit.controlador.ControladorDefinicionAuditoria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Definicion_Auditoria {

	//ATRIBUTOS
	private static I_Definicion_Auditoria miIDefinicionAuditoria;
	private static JFrame frame;
	private JLabel labelNombreAuditoria;
	private static JTextField textFieldAuditoria;
	private JScrollPane scrollPane;
	private JLabel labelPreguntas;
	private JButton botonAñadirPregunta;
	private JButton botonEliminarPregunta;
	private JButton botonAnadirAuditoria;
	private JButton botonCancelarAuditoria;

	//MÉTODO CONSTRUCTOR
	private I_Definicion_Auditoria() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Definicion_Auditoria getMiIDefinicion_Auditoria() {
		if (miIDefinicionAuditoria == null) {
			miIDefinicionAuditoria = new I_Definicion_Auditoria();
		}
		return miIDefinicionAuditoria;
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	public static JTextField getTextFieldAuditoria() {
		return textFieldAuditoria;
	}
	
	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		labelNombreAuditoria = new JLabel("Nombre de la auditoria:");
		labelNombreAuditoria.setBounds(53, 11, 155, 14);
		
		textFieldAuditoria = new JTextField();
		textFieldAuditoria.setBounds(218, 8, 157, 20);
		textFieldAuditoria.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 65, 242, 348);
		
		labelPreguntas = new JLabel("Preguntas:");
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.setBounds(22, 49, 242, 14);
		
		botonAñadirPregunta = new JButton("Añadir pregunta");
		botonAñadirPregunta.setBounds(329, 65, 145, 23);
		botonAñadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		botonEliminarPregunta = new JButton("Eliminar pregunta");
		botonEliminarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonEliminarPregunta.setBounds(329, 342, 145, 23);
		
		botonAnadirAuditoria = new JButton("Añadir auditoria");
		botonAnadirAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonAnadirAuditoria.setBounds(22, 428, 145, 23);

		botonCancelarAuditoria = new JButton("Cancelar");
		botonCancelarAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getMiControladorDefinicionAuditoria().cancelarAuditoria();
			}
		});
		botonCancelarAuditoria.setBounds(367, 428, 89, 23);
				
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(labelNombreAuditoria);
		frame.getContentPane().add(textFieldAuditoria);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(labelPreguntas);
		frame.getContentPane().add(botonAñadirPregunta);
		frame.getContentPane().add(botonEliminarPregunta);
		frame.getContentPane().add(botonAnadirAuditoria);
		frame.getContentPane().add(botonCancelarAuditoria);
		frame.setVisible(true);
	}
}