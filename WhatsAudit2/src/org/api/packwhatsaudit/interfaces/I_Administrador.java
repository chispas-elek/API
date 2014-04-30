package org.api.packwhatsaudit.interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.api.packwhatsaudit.controlador.ControladorAdministrador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Administrador {

	//ATRIBUTOS
	private static I_Administrador miIAdministrador;
	private static JFrame frame;
	private JScrollPane scrollPane;
	private static JList<String> lista;
	private static DefaultListModel<String> modeloLista;
	private JButton botonNuevo;
	private JButton botonBorrar;

	//MÉTODO CONSTRUCTOR
	private I_Administrador() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Administrador getMiIAdministrador() {
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
		ControladorAdministrador.getMiControladorAdministrador().introducirAuditorias();

		lista = new JList<String>();
		lista.setModel(modeloLista);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 187, 271);
		scrollPane.setViewportView(lista);
		
		botonNuevo = new JButton("Nueva auditoria");
		botonNuevo.setBounds(236, 9, 148, 23);
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		botonBorrar = new JButton("Borrar auditoria");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorAdministrador.getMiControladorAdministrador().comprobarSeleccionLista();
			}
		});
		botonBorrar.setBounds(236, 259, 148, 23);
				
		frame = new JFrame();
		frame.setTitle("Menu :: WhatsAudit");
		frame.setBounds(100, 100, 400, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonNuevo);
		frame.getContentPane().add(botonBorrar);
		frame.setVisible(true);
	}
}