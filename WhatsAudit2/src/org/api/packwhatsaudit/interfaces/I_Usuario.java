package org.api.packwhatsaudit.interfaces;

import org.api.packwhatsaudit.controlador.*;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class I_Usuario {

	//ATRIBUTOS
	private static I_Usuario miIUsuario;
	private static JFrame frame;
	private JLabel labelAuditorias;
	private JScrollPane scrollPane;
	private static JList<String> lista;
	private static DefaultListModel<String> modeloLista;
	private JButton botonRellenar;
	private JButton botonHistorico;

	//MÉTODO CONSTRUCTOR
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

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		labelAuditorias = new JLabel("Auditorias disponibles:");
		labelAuditorias.setHorizontalAlignment(SwingConstants.CENTER);
		labelAuditorias.setFont(new Font("Arial Black", Font.PLAIN, 11));
		labelAuditorias.setBounds(37, 29, 243, 14);
		
		modeloLista = new DefaultListModel<String>();
		ControladorUsuario.getMiControladorUsuario().introducirAuditorias();

		lista = new JList<String>();
		lista.setModel(modeloLista);

		scrollPane = new JScrollPane(lista);
		scrollPane.setBounds(37, 54, 243, 200);
		scrollPane.setViewportView(lista);

		botonRellenar = new JButton("Rellenar auditoria");
		botonRellenar.setBounds(382, 54, 158, 23);
		botonRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorUsuario.getMiControladorUsuario().realizarAuditoria();
			}
		});

		botonHistorico = new JButton("Histórico de auditorias");
		botonHistorico.setBounds(382, 231, 180, 23);
		botonHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorUsuario.getMiControladorUsuario().abrirHistorico();
			}
		});
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonRellenar);
		frame.getContentPane().add(botonHistorico);
		frame.getContentPane().add(labelAuditorias);
		frame.setVisible(true);
	}
}