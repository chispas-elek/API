package org.api.whatsaudit.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

import org.api.packwhatsaudit.modelo.*;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Usuario {

	//ATRIBUTOS
	private JFrame frame;
	private JList<String> list;

	//MÉTODO CONSTRUCTOR
	public I_Usuario() {
		inicializarVentana();
	}

	//MÉTODOS DEFINIDOS
	private void inicializarVentana() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 54, 243, 200);


		list = new JList<String>();
		DefaultListModel<String> modeloLista = new DefaultListModel<String>();
		ArrayList<Auditoria> listaRecibe = GestorAuditoria.getGestorAuditoria().obtenerAuditorias();
		Iterator<Auditoria> itr = listaRecibe.iterator();
		while (itr.hasNext()) {
			modeloLista.addElement(itr.next().getNombre());
		}
		list.setModel(modeloLista);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Rellenar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() == null) {
					//error
				} else {
					//llamar nueva interfaz
				}
			}
		});
		btnNewButton.setBounds(391, 87, 89, 23);

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnNewButton);
	}

	public static void main(String[] args) {
		I_Usuario window = new I_Usuario();
		window.frame.setVisible(true);
	}
}