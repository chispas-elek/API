package org.api.packwhatsaudit.interfaces;

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
import org.api.packwhatsaudit.controlador.ControladorUsuario;

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
	private JButton botonVolver;

	//MÉTODO CONSTRUCTOR
	private I_Usuario() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Usuario getIUsuario() {
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
		labelAuditorias.setBounds(10, 29, 364, 14);
		
		modeloLista = new DefaultListModel<String>();
		ControladorUsuario.getMiControladorUsuario().introducirAuditorias();

		lista = new JList<String>();
		lista.setModel(modeloLista);

		scrollPane = new JScrollPane(lista);
		scrollPane.setBounds(10, 54, 364, 200);
		scrollPane.setViewportView(lista);

		botonRellenar = new JButton("Rellenar auditoria");
		botonRellenar.setBounds(10, 280, 158, 23);
		botonRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorUsuario.getMiControladorUsuario().realizarAuditoria();
			}
		});

		botonHistorico = new JButton("Histórico de auditorias");
		botonHistorico.setBounds(10, 314, 180, 23);
		botonHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorUsuario.getMiControladorUsuario().abrirHistorico();
			}
		});
		
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorUsuario.getMiControladorUsuario().volverLogin();
			}
		});
		botonVolver.setBounds(265, 280, 89, 23);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(botonRellenar);
		frame.getContentPane().add(botonHistorico);
		frame.getContentPane().add(labelAuditorias);
		frame.getContentPane().add(botonVolver);
		frame.setVisible(true);
	}
}