package org.api.packwhatsaudit.interfaces;

import org.api.packwhatsaudit.controlador.ControladorLogin;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Login {

	//ATRIBUTOS
	private static I_Login miILogin;
	private static JFrame frame;
	private JLabel labelUsuario;
	private static JTextField textFieldUsuario;
	private JLabel labelContrase�a;
	private static JTextField passwordFieldContrase�a;
	private JButton botonEntrar;

	//M�TODO CONSTRUCTOR
	private I_Login() {
		inicializarVentana();
	}

	//GETTERS Y SETTERS
	public static I_Login getMiILogin() {
		if (miILogin == null) {
			miILogin = new I_Login();
		}
		return miILogin;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public static JTextField getPasswordFieldContrase�a() {
		return passwordFieldContrase�a;
	}

	//M�TODOS DEFINIDOS
	private void inicializarVentana() {
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(123, 53, 93, 14);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(276, 50, 129, 20);
		textFieldUsuario.setColumns(10);
		
		labelContrase�a = new JLabel("Contrase�a");
		labelContrase�a.setBounds(123, 81, 93, 14);
		
		passwordFieldContrase�a = new JPasswordField();
		passwordFieldContrase�a.setColumns(10);
		passwordFieldContrase�a.setBounds(276, 78, 129, 20);
		
		botonEntrar = new JButton("Aceptar");
		botonEntrar.setBounds(276, 123, 129, 23);
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorLogin.getMiControladorLogin().comprobarDatosLogin();
			}
		});
		
		frame = new JFrame();
		frame.setTitle("Login :: WhatsAudit");
		frame.setBounds(100, 100, 600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(labelUsuario);
		frame.getContentPane().add(textFieldUsuario);
		frame.getContentPane().add(labelContrase�a);
		frame.getContentPane().add(passwordFieldContrase�a);
		frame.getContentPane().add(botonEntrar);
		frame.setVisible(true);
	}

	//MAIN
	public static void main(String[] args) {
		I_Login.getMiILogin();
	}
}