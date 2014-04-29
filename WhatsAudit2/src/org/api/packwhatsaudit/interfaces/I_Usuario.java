package org.api.packwhatsaudit.interfaces;

import org.api.packwhatsaudit.controlador.*;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Usuario {

	//ATRIBUTOS
	private static I_Usuario miIUsuario;
	private static JFrame frame;
	private JScrollPane scrollPane;
	private static JList<String> lista;
	private static DefaultListModel<String> modeloLista;
	private JButton botonRellenar;
	private JButton botonHistorico;

	//M�TODO CONSTRUCTOR
	private I_Usuario() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Usuario getMiIUsuario() {
		if (miIUsuario == null) {
			miIUsuario = new I_Usuario();
		}
		return miIUsuario;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	public static JList<String> getLista() {
		return lista;
	}

	//M�TODOS DEFINIDOS
	private void inicializarVentana() {
		modeloLista = new DefaultListModel<String>();
		ControladorUsuario.getMiControladorUsuario().introducirAuditorias();

		lista = new JList<String>();
		lista.setModel(modeloLista);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 54, 243, 200);
		scrollPane.setViewportView(lista);

		botonRellenar = new JButton("Rellenar auditoria");
		botonRellenar.setBounds(382, 54, 158, 23);
		botonRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorUsuario.getMiControladorUsuario().comprobarSeleccionLista();
			}
		});

		botonHistorico = new JButton("Hist�rico de auditorias");
		botonHistorico.setBounds(382, 231, 158, 23);
		botonHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonRellenar);
		frame.getContentPane().add(botonHistorico);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		I_Usuario.getMiIUsuario();
	}
}