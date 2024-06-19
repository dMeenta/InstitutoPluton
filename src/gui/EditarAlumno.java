package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrayList.ArrayAlumno;
import baseDdatos.Enlace;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class EditarAlumno extends JDialog implements ActionListener, KeyListener {
	Connection con = Enlace.getEnlace();
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodAlm;
	private JTextField txtNomEd;
	private JTextField txtApeEd;
	private JTextField txtEdadEd;
	private JTextField txtAulaEd;
	private JButton btnGuardarEd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarAlumno dialog = new EditarAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarAlumno() {
		setTitle("Editar Alumno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarAlumno.class.getResource("/img/pipipi.png")));
		setBounds(870, 100, 303, 286);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCdigoDelAlumno = new JLabel("Código del Alumno:");
			lblCdigoDelAlumno.setHorizontalAlignment(SwingConstants.LEFT);
			lblCdigoDelAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCdigoDelAlumno.setBounds(10, 11, 164, 23);
			contentPanel.add(lblCdigoDelAlumno);
		}
		{
			txtCodAlm = new JTextField();
			txtCodAlm.setBounds(169, 14, 108, 20);
			contentPanel.add(txtCodAlm);
			txtCodAlm.setColumns(10);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombre.setBounds(10, 79, 90, 23);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblLleneLosCampos = new JLabel("Llene los Campos que Desea Editar");
			lblLleneLosCampos.setHorizontalAlignment(SwingConstants.CENTER);
			lblLleneLosCampos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblLleneLosCampos.setBounds(10, 45, 267, 23);
			contentPanel.add(lblLleneLosCampos);
		}
		{
			txtNomEd = new JTextField();
			txtNomEd.addKeyListener(this);
			txtNomEd.setColumns(10);
			txtNomEd.setBounds(91, 82, 186, 20);
			contentPanel.add(txtNomEd);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblApellidos.setBounds(10, 113, 90, 23);
			contentPanel.add(lblApellidos);
		}
		{
			txtApeEd = new JTextField();
			txtApeEd.addKeyListener(this);
			txtApeEd.setColumns(10);
			txtApeEd.setBounds(91, 113, 186, 20);
			contentPanel.add(txtApeEd);
		}
		{
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setHorizontalAlignment(SwingConstants.LEFT);
			lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEdad.setBounds(10, 147, 90, 23);
			contentPanel.add(lblEdad);
		}
		{
			txtEdadEd = new JTextField();
			txtEdadEd.addKeyListener(this);
			txtEdadEd.setColumns(10);
			txtEdadEd.setBounds(91, 147, 95, 20);
			contentPanel.add(txtEdadEd);
		}
		{
			JLabel lblAula = new JLabel("Aula:");
			lblAula.setHorizontalAlignment(SwingConstants.LEFT);
			lblAula.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAula.setBounds(10, 178, 90, 23);
			contentPanel.add(lblAula);
		}
		{
			txtAulaEd = new JTextField();
			txtAulaEd.setColumns(10);
			txtAulaEd.setBounds(91, 181, 95, 20);
			contentPanel.add(txtAulaEd);
		}
		{
			btnGuardarEd = new JButton("Guardar");
			btnGuardarEd.addActionListener(this);
			btnGuardarEd.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGuardarEd.setBounds(91, 213, 124, 23);
			contentPanel.add(btnGuardarEd);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardarEd) {
			do_btnGuardarEd_actionPerformed(arg0);
		}
	}
	protected void do_btnGuardarEd_actionPerformed(ActionEvent arg0) {
		try{
			if(getCod().isEmpty()){
				JOptionPane.showMessageDialog(null, "Ingrese un código de Alumno para editar");
			}else{
				ArrayAlumno editar = new ArrayAlumno();
				editar.Admin_EditarAlumno(getCod(), getNom(), getApe(), getEdad(), getAula());
				JOptionPane.showMessageDialog(this, "Alumno Editado Correctamente \n Actualice la Tabla Dando Click en el botón 'Ver Alumnos'");
				Limpiar();
			}
		}catch(Exception E){
			JOptionPane.showMessageDialog(null, "Error"+E);
		}
	}
        
        public void Actualizar(){
            this.dispose();
        }
        
	public void Limpiar(){
		txtApeEd.setText("");
		txtAulaEd.setText("");
		txtEdadEd.setText("");
		txtNomEd.setText("");
		txtCodAlm.setText("");
	}
	public String getCod(){
		return txtCodAlm.getText();
	}
	public int getEdad(){
		if(txtEdadEd.getText().isEmpty()){
			return 0;
		}return Integer.parseInt(txtEdadEd.getText());
	}
	public String getNom(){
		if(txtNomEd.getText().isEmpty()){
			return ".";
		}return txtNomEd.getText();
	}
	public String getApe(){
		if(txtApeEd.getText().isEmpty()){
			return ".";
		}return txtApeEd.getText();
	}
	public String getAula(){
		if(txtAulaEd.getText().isEmpty()){
			return ".";
		}return txtAulaEd.getText();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtApeEd) {
			do_txtApeEd_keyTyped(arg0);
		}
		if (arg0.getSource() == txtNomEd) {
			do_txtNomEd_keyTyped(arg0);
		}
		if (arg0.getSource() == txtEdadEd) {
			do_txtEdadEd_keyTyped(arg0);
		}
	}
	protected void do_txtEdadEd_keyTyped(KeyEvent arg0) {
		char onlynum = arg0.getKeyChar();
		if(Character.isLetter(onlynum)){
			arg0.consume();
			JOptionPane.showMessageDialog(this, "Solo se permiten n�meros");
		}
	}
	protected void do_txtNomEd_keyTyped(KeyEvent arg0) {
		char onlynum = arg0.getKeyChar();
		if(Character.isDigit(onlynum)){
			arg0.consume();
			JOptionPane.showMessageDialog(this, "Solo se permiten letras");
		}
	}
	protected void do_txtApeEd_keyTyped(KeyEvent arg0) {
		char onlynum = arg0.getKeyChar();
		if(Character.isDigit(onlynum)){
			arg0.consume();
			JOptionPane.showMessageDialog(this, "Solo se permiten letras");
		}
	}
}
