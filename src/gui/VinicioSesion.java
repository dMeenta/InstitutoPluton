package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDdatos.Enlace;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyEvent;

public class VinicioSesion extends JFrame implements ActionListener, KeyListener {
	Connection con = Enlace.getEnlace();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblIngresarComo;
	private JLabel lblContrasea;
	private JPasswordField passwordField;
	private JButton btnIniciarSesion;
	private JTextField txtidUsuario;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VinicioSesion frame = new VinicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VinicioSesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VinicioSesion.class.getResource("/img/pipipi.png")));
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Welcome to the Pluto Institute Data System");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(14, 0, 476, 44);
			contentPane.add(lblNewLabel);
		}
		{
			lblIngresarComo = new JLabel("User:");
			lblIngresarComo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblIngresarComo.setBounds(20, 55, 139, 28);
			contentPane.add(lblIngresarComo);
		}
		{
			lblContrasea = new JLabel("Password:");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblContrasea.setBounds(20, 118, 139, 28);
			contentPane.add(lblContrasea);
		}
		{
			passwordField = new JPasswordField();
			passwordField.addKeyListener(this);
			passwordField.setBounds(125, 122, 154, 24);
			contentPane.add(passwordField);
		}
		{
			btnIniciarSesion = new JButton("Log in");
			btnIniciarSesion.addActionListener(this);
			btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnIniciarSesion.setBounds(20, 173, 259, 26);
			contentPane.add(btnIniciarSesion);
		}
		{
			txtidUsuario = new JTextField();
			txtidUsuario.addKeyListener(this);
			txtidUsuario.setBounds(125, 58, 154, 26);
			contentPane.add(txtidUsuario);
			txtidUsuario.setColumns(10);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(VinicioSesion.class.getResource("/img/piopio.png")));
			label.setBounds(303, 32, 170, 170);
			contentPane.add(label);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIniciarSesion) {
			do_btnIniciarSesion_actionPerformed(arg0);
		}
	}
	
	
	protected void do_btnIniciarSesion_actionPerformed(ActionEvent arg0) {
		validarUsuario();
	}
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			validarUsuario();
		}
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtidUsuario) {
			do_txtidUsuario_keyTyped(arg0);
		}
		if (arg0.getSource() == passwordField) {
			do_passwordField_keyTyped(arg0);
		}
	}
	protected void do_passwordField_keyTyped(KeyEvent arg0) {
		char onlynum = arg0.getKeyChar();
		if(Character.isLetter(onlynum)){
			arg0.consume();
			JOptionPane.showMessageDialog(this, "Only numbers allowed");
		}
	}
	protected void do_txtidUsuario_keyTyped(KeyEvent arg0) {
		if(txtidUsuario.getText().length()>15){
			arg0.consume();
			JOptionPane.showMessageDialog(this, "Ingrese caracteres demas");
		}
	}
	public void validarUsuario(){
		int password = Integer.parseInt(passwordField.getText());
		String user = txtidUsuario.getText().toUpperCase();
		String MySql = "Select * from usuarios where codUsuario = '"+user+"' and passwordUsuario = '"+password+"'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(MySql);
			if(rs.next()){
				if(rs.getString("codUsuario").contains("SEC")){
					this.dispose();
					try {
						CallableStatement stm1 = con.prepareCall("{call admin_Login(?)}");
						stm1.setString(1, user);
						stm1.executeUpdate();
						Menu menu = new Menu();
						menu.setVisible(true);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
					}
					
				}else{
					this.dispose();
					try {
						CallableStatement stm2 = con.prepareCall("{call docente_Login(?)}");
						stm2.setString(1, user);
						stm2.executeUpdate();
						Menu menu = new Menu();
						menu.setVisible(true);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
					}
				}
				
			}else JOptionPane.showMessageDialog(this, "Incorrect User or Password");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
		}
	}
	
}
