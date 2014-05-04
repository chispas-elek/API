package org.api.packwhatsaudit.interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.api.packwhatsaudit.controlador.ControladorAdministrador;

public class I_Administrador {

	//ATRIBUTOS
	private static I_Administrador miIAdministrador;
	private static JFrame frame;
	private JScrollPane scrollPane;
	private static JList<String> lista;
	private static DefaultListModel<String> modeloLista;
	private JButton botonVolver;
	private JButton botonNuevo;

	//MÉTODO CONSTRUCTOR
	private I_Administrador() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Administrador getIAdministrador() {
		if (miIAdministrador == null) {
			miIAdministrador = new I_Administrador();
		}
		return miIAdministrador;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JList<String> getLista() {
		return lista;
	}

	public static DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		modeloLista = new DefaultListModel<String>();
		ControladorAdministrador.getControladorAdministrador().introducirAuditorias();

		lista = new JList<String>();
		lista.setModel(modeloLista);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 374, 271);
		scrollPane.setViewportView(lista);
		
		botonNuevo = new JButton("Nueva auditoria");
		botonNuevo.setBounds(10, 317, 148, 23);
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorAdministrador.getControladorAdministrador().añadirAuditoria();
			}
		});
		
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(295, 317, 89, 23);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorAdministrador.getControladorAdministrador().volverLogin();
			}
		});
				
		frame = new JFrame();
		frame.setTitle("Menu Administrador :: WhatsAudit");
		frame.setBounds(100, 100, 400, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonNuevo);
		frame.getContentPane().add(botonVolver);
		frame.setVisible(true);
	}
}