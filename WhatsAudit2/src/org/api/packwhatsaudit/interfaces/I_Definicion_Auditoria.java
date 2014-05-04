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
	private static JFrame frmAadirAuditoria;
	private JLabel labelNombreAuditoria;
	private static JTextField textFieldAuditoria;
	private JLabel labelNombrePregunta;
	private static JTextField textFieldPregunta;
	private JLabel labelPreguntas;
	private JScrollPane scrollPane;
	private static JList<String> lista;
	private static DefaultListModel<String> modeloLista;
	private JButton botonA�adirPregunta;
	private JButton botonEliminarPregunta;
	private JButton botonAnadirAuditoria;
	private JButton botonCancelarAuditoria;

	//M�TODO CONSTRUCTOR
	private I_Definicion_Auditoria() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Definicion_Auditoria getIDefinicion_Auditoria() {
		if (miIDefinicionAuditoria == null) {
			miIDefinicionAuditoria = new I_Definicion_Auditoria();
		}
		return miIDefinicionAuditoria;
	}
	
	public static JFrame getFrame() {
		return frmAadirAuditoria;
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

	//M�TODOS DEFINIDOS
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
		
		botonA�adirPregunta = new JButton("A�adir");
		botonA�adirPregunta.setBounds(367, 61, 107, 23);
		botonA�adirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getControladorDefinicionAuditoria().a�adirPreguntaLista();
			}
		});
		
		botonEliminarPregunta = new JButton("Eliminar pregunta");
		botonEliminarPregunta.setBounds(329, 342, 145, 23);
		botonEliminarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getControladorDefinicionAuditoria().eliminarPreguntaLista();
			}
		});
		
		botonAnadirAuditoria = new JButton("A�adir auditoria");
		botonAnadirAuditoria.setBounds(22, 428, 145, 23);
		botonAnadirAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getControladorDefinicionAuditoria().a�adirPreguntasYAuditoria();
			}
		});
		
		botonCancelarAuditoria = new JButton("Cancelar");
		botonCancelarAuditoria.setBounds(367, 428, 89, 23);
		botonCancelarAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDefinicionAuditoria.getControladorDefinicionAuditoria().cancelarAuditoria();
			}
		});
						
		frmAadirAuditoria = new JFrame();
		frmAadirAuditoria.setTitle("A\u00F1adir auditoria :: WhatsAudit");
		frmAadirAuditoria.setBounds(100, 100, 500, 500);
		frmAadirAuditoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAadirAuditoria.getContentPane().setLayout(null);
		frmAadirAuditoria.getContentPane().add(labelNombreAuditoria);
		frmAadirAuditoria.getContentPane().add(textFieldAuditoria);
		frmAadirAuditoria.getContentPane().add(labelNombrePregunta);
		frmAadirAuditoria.getContentPane().add(scrollPane);
		frmAadirAuditoria.getContentPane().add(labelPreguntas);
		frmAadirAuditoria.getContentPane().add(botonA�adirPregunta);
		frmAadirAuditoria.getContentPane().add(botonEliminarPregunta);
		frmAadirAuditoria.getContentPane().add(botonAnadirAuditoria);
		frmAadirAuditoria.getContentPane().add(botonCancelarAuditoria);
		frmAadirAuditoria.getContentPane().add(textFieldPregunta);
		frmAadirAuditoria.setVisible(true);
	}
}