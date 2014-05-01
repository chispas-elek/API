package org.api.packwhatsaudit.interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private JLabel labelNombrePregunta;
	private static JTextField textFieldPregunta;
	private JLabel labelPreguntas;
	private JScrollPane scrollPane;
	private static JList<String> lista;
	private static DefaultListModel<String> modeloLista;
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
	
	public static JTextField getTextFieldPregunta() {
		return textFieldPregunta;
	}

	public static void setTextFieldPregunta(JTextField textFieldPregunta) {
		I_Definicion_Auditoria.textFieldPregunta = textFieldPregunta;
	}
	
	public static JList<String> getLista() {
		return lista;
	}

	public static DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		labelNombreAuditoria = new JLabel("Nombre de la auditoria:");
		labelNombreAuditoria.setBounds(22, 11, 155, 14);
		
		textFieldAuditoria = new JTextField();
		textFieldAuditoria.setBounds(200, 8, 157, 20);
		textFieldAuditoria.setColumns(10);
		
		labelNombrePregunta = new JLabel("Nombre de la pregunta:");
		labelNombrePregunta.setBounds(22, 65, 155, 14);
		
		
		textFieldPregunta = new JTextField();
		textFieldPregunta.setColumns(10);
		textFieldPregunta.setBounds(200, 62, 157, 20);
		
		modeloLista = new DefaultListModel<String>();
		
		lista = new JList<String>();
		lista.setModel(modeloLista);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 118, 242, 295);
		scrollPane.setViewportView(lista);
		
		labelPreguntas = new JLabel("Preguntas:");
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.setBounds(22, 93, 242, 14);
		
		botonAñadirPregunta = new JButton("Añadir");
		botonAñadirPregunta.setBounds(367, 61, 107, 23);
		botonAñadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getMiControladorDefinicionAuditoria().añadirPreguntaLista();
			}
		});
		
		botonEliminarPregunta = new JButton("Eliminar pregunta");
		botonEliminarPregunta.setBounds(329, 342, 145, 23);
		botonEliminarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getMiControladorDefinicionAuditoria().eliminarPreguntaLista();
			}
		});
		
		botonAnadirAuditoria = new JButton("Añadir auditoria");
		botonAnadirAuditoria.setBounds(22, 428, 145, 23);
		botonAnadirAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getMiControladorDefinicionAuditoria().añadirPreguntasYAuditoria();
			}
		});
		
		botonCancelarAuditoria = new JButton("Cancelar");
		botonCancelarAuditoria.setBounds(367, 428, 89, 23);
		botonCancelarAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getMiControladorDefinicionAuditoria().cancelarAuditoria();
			}
		});
						
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(labelNombreAuditoria);
		frame.getContentPane().add(textFieldAuditoria);
		frame.getContentPane().add(labelNombrePregunta);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(labelPreguntas);
		frame.getContentPane().add(botonAñadirPregunta);
		frame.getContentPane().add(botonEliminarPregunta);
		frame.getContentPane().add(botonAnadirAuditoria);
		frame.getContentPane().add(botonCancelarAuditoria);
		frame.getContentPane().add(textFieldPregunta);
		frame.setVisible(true);
	}
}