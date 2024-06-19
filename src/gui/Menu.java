package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayAlumno;
import arrayList.ArrayAula;
import arrayList.ArrayHistorial;
import baseDdatos.Enlace;
import compo.Aula;
import hijos.Alumno;
import baseDdatos.Historial;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Menu extends JFrame implements ActionListener, KeyListener {
	//Esta conexión fue usada para mostrar los datos de aquel que Inicio Sesión
	Connection con = Enlace.getEnlace();
	//Crea la ventana Contacto
	EditarAlumno editar = new EditarAlumno();

	private JPanel contentPane;
	private JMenuBar menuBar; 
	private JMenu mnArchivo;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmConctacto;
	private JLabel lblUser;
	private JLabel lblCode;
	private JTextField txtMcod;
	private JLabel label_2;
	private JTextField txtMnom;
	private JLabel label_3;
	private JTextField txtMape;
	private JLabel lblTelf;
	private JTextField txtMtelf;
	private JTextField txtMedad;
	private JLabel lblEdad;
	private JLabel imgUser;
	private JMenuItem mntmHistorial;
	private JLabel lblRegistroNombre;
	private JTextField txtRegistroNombre;
	private JTextField txtNota1;
	private JLabel lblNota1;
        private JLabel lblRegistroAula;
	private JLabel lblNota2;
	private JTextField txtNota2;
	private JLabel lblNota3;
	private JTextField txtNota3;
	private JTextField txtRegistroApellidos;
	private JLabel lblRegistroApellidos;
	private JLabel lblRegistroEdad;
	private JTextField txtRegistroEdad;
        private JTextField txtRegistroAula;
	private JButton btnRegistrarAlumno;
	private JButton btnGuardarNotas;
	private JButton btnEliminarAlumno;
	private JTextField txtAlumnoCod;
	private JLabel lblCodAlumno;
	private JLabel lblTitle;
	private JLabel lblTitleBar;
	private JScrollPane scrollPane;
	private JTable tbAlumnos;
	private JMenuItem mntmVerAlumnos;
	private JMenuItem mntmVerAulas;
	private JLabel lblAulaCod;
	private JComboBox cboAulaStatus;
	private JLabel lblAulaStatus;
	private JTextField txtCodAula;
	private JButton btnGuardarAulaStatus;
	private JLabel lblAulaUser;
	private JMenu mnVer;
	private JLabel label_7;
	private JTextField txtMaula;
	private JLabel lblHabilitarinhabilitarAula;
	private JButton btnEditarAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/pipipi.png")));
		setTitle("Menú");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 13, 770, 728);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
				{
					mntmCerrarSesin = new JMenuItem("Log out");
					mntmCerrarSesin.addActionListener(this);
					mnArchivo.add(mntmCerrarSesin);
				}
			}
			{
				mnVer = new JMenu("Show");
				menuBar.add(mnVer);
				mntmVerAlumnos = new JMenuItem("Show Students");
				mnVer.add(mntmVerAlumnos);
				mntmVerAlumnos.addActionListener(this);
				{
					mntmHistorial = new JMenuItem("Show Record");
					mnVer.add(mntmHistorial);
					mntmHistorial.addActionListener(this);
				}
				{
					mntmVerAulas = new JMenuItem("Show Classrooms");
					mnVer.add(mntmVerAulas);
					mntmVerAulas.addActionListener(this);
				}
				{
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                //img
		{
			imgUser = new JLabel("");
			imgUser.setIcon(new ImageIcon(Menu.class.getResource("/img/user.png")));
			imgUser.setBounds(10, 11, 164, 204);
			contentPane.add(imgUser);
		}
                //Datos Usuario
		{
			lblUser = new JLabel("Bienvenido");
			lblUser.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblUser.setBounds(184, -1, 400, 45);
			contentPane.add(lblUser);
		}
		{
			lblCode = new JLabel("Cod:");
			lblCode.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCode.setBounds(184, 45, 150, 30);
			contentPane.add(lblCode);
		}
		{
			lblTelf = new JLabel("Telf:");
			lblTelf.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTelf.setBounds(184, 90, 200, 30);
			contentPane.add(lblTelf);
		}
		{
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEdad.setBounds(184, 135, 100, 30);
			contentPane.add(lblEdad);
		}
                {
			lblAulaUser = new JLabel("Aula:");
			lblAulaUser.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAulaUser.setBounds(184, 180, 120, 30);
			contentPane.add(lblAulaUser);
		}
                //Aula Status
                {
			lblHabilitarinhabilitarAula = new JLabel("Habilitar/Inhabilitar Aula");
			lblHabilitarinhabilitarAula.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblHabilitarinhabilitarAula.setBounds(440, 45, 200, 25);
			contentPane.add(lblHabilitarinhabilitarAula);
		}
                {
			lblAulaCod = new JLabel("Código del Aula:");
			lblAulaCod.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAulaCod.setBounds(440, 90, 140, 25);
			contentPane.add(lblAulaCod);
		}
                {
			txtCodAula = new JTextField();
			txtCodAula.setColumns(10);
			txtCodAula.setBounds(570, 93, 140, 20);
			contentPane.add(txtCodAula);
		}
                {
			lblAulaStatus = new JLabel("Estado:");
			lblAulaStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAulaStatus.setBounds(440, 135, 100, 25);
			contentPane.add(lblAulaStatus);
		}
		{
			cboAulaStatus = new JComboBox();
			cboAulaStatus.setModel(new DefaultComboBoxModel(new String[] {"Habilitada", "Inhabilitada"}));
			cboAulaStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
			cboAulaStatus.setBounds(515, 135, 185, 28);
			contentPane.add(cboAulaStatus);
		}
		{
			btnGuardarAulaStatus = new JButton("Guardar");
			btnGuardarAulaStatus.addActionListener(this);
			btnGuardarAulaStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGuardarAulaStatus.setBounds(511, 180, 125, 25);
			contentPane.add(btnGuardarAulaStatus);
		}
                // aaa
                {
			lblTitle = new JLabel("Registro De Alumnos");
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblTitle.setBounds(10, 225, 207, 44);
			contentPane.add(lblTitle);
		}
		{
			lblTitleBar = new JLabel("----------------------------------------------------------------------------");
			lblTitleBar.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblTitleBar.setBounds(203, 231, 551, 32);
			contentPane.add(lblTitleBar);
		}
                //Registro de Alumnos
		{
			lblRegistroNombre = new JLabel("Nombre:");
			lblRegistroNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegistroNombre.setBounds(10, 280, 90, 23);
			contentPane.add(lblRegistroNombre);
		}
		{
			txtRegistroNombre = new JTextField();
			txtRegistroNombre.addKeyListener(this);
			txtRegistroNombre.setColumns(10);
			txtRegistroNombre.setBounds(90, 283, 200, 20);
			contentPane.add(txtRegistroNombre);
		}
                {
			lblRegistroApellidos = new JLabel("Apellidos:");
			lblRegistroApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegistroApellidos.setBounds(320, 280, 90, 23);
			contentPane.add(lblRegistroApellidos);
		}
		{
			txtRegistroApellidos = new JTextField();
			txtRegistroApellidos.addKeyListener(this);
			txtRegistroApellidos.setColumns(10);
			txtRegistroApellidos.setBounds(400, 283, 200, 20);
			contentPane.add(txtRegistroApellidos);
		}
		{
			lblRegistroEdad = new JLabel("Edad:");
			lblRegistroEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegistroEdad.setBounds(10, 315, 90, 23);
			contentPane.add(lblRegistroEdad);
		}
		{
			txtRegistroEdad = new JTextField();
			txtRegistroEdad.addKeyListener(this);
			txtRegistroEdad.setColumns(10);
			txtRegistroEdad.setBounds(90, 318, 75, 20);
			contentPane.add(txtRegistroEdad);
		}
                {
                    lblRegistroAula = new JLabel("Aula:");
                    lblRegistroAula.setFont(new Font("Tahoma", Font.BOLD, 14));
                    lblRegistroAula.setBounds(320, 315, 90, 23);
                    contentPane.add(lblRegistroAula);
                }
                {
                    txtRegistroAula = new JTextField();
                    txtRegistroAula.addKeyListener(this);
                    txtRegistroAula.setColumns(10);
                    txtRegistroAula.setBounds(400, 318, 75, 20);
                    contentPane.add(txtRegistroAula);
                }
                {
			btnRegistrarAlumno = new JButton("Registrar Alumno");
			btnRegistrarAlumno.addActionListener(this);
			btnRegistrarAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnRegistrarAlumno.setBounds(120, 350, 500, 23);
			contentPane.add(btnRegistrarAlumno);
		}
                {
			lblCodAlumno = new JLabel("Buscar / Eliminar Alumno por Código:");
			lblCodAlumno.setHorizontalAlignment(SwingConstants.LEFT);
			lblCodAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCodAlumno.setBounds(10, 425, 270, 23);
			contentPane.add(lblCodAlumno);
		}
                {
			txtAlumnoCod = new JTextField();
			txtAlumnoCod.setColumns(10);
			txtAlumnoCod.setBounds(280, 428, 200, 20);
			txtAlumnoCod.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0){
					String cod = txtAlumnoCod.getText();
					txtAlumnoCod.setText(cod);
					ListarAl(cod);
				}
			});
			contentPane.add(txtAlumnoCod);
		}
		{
			btnEditarAlumno = new JButton("Editar Alumno");
			btnEditarAlumno.addActionListener(this);
			btnEditarAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnEditarAlumno.setBounds(500, 390, 193, 23);
			contentPane.add(btnEditarAlumno);
		}
                {
			btnEliminarAlumno = new JButton("Eliminar Alumno");
			btnEliminarAlumno.addActionListener(this);
			btnEliminarAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnEliminarAlumno.setBounds(500, 426, 193, 23);
			contentPane.add(btnEliminarAlumno);
		}
                //Notas
                {
			lblNota1 = new JLabel("Nota 1:");
			lblNota1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNota1.setBounds(511, 333, 90, 23);
			contentPane.add(lblNota1);
		}
		{
			txtNota1 = new JTextField();
			txtNota1.addKeyListener(this);
			txtNota1.setColumns(10);
			txtNota1.setBounds(583, 336, 96, 20);
			contentPane.add(txtNota1);
		}
		{
			lblNota2 = new JLabel("Nota 2:");
			lblNota2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNota2.setBounds(511, 367, 90, 23);
			contentPane.add(lblNota2);
		}
		{
			txtNota2 = new JTextField();
			txtNota2.addKeyListener(this);
			txtNota2.setColumns(10);
			txtNota2.setBounds(583, 370, 96, 20);
			contentPane.add(txtNota2);
		}
		{
			lblNota3 = new JLabel("Nota 3:");
			lblNota3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNota3.setBounds(511, 401, 90, 23);
			contentPane.add(lblNota3);
		}
		{
			txtNota3 = new JTextField();
			txtNota3.addKeyListener(this);
			txtNota3.setColumns(10);
			txtNota3.setBounds(583, 404, 96, 20);
			contentPane.add(txtNota3);
		}
		{
			btnGuardarNotas = new JButton("Guardar Notas");
			btnGuardarNotas.addActionListener(this);
			btnGuardarNotas.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(btnGuardarNotas);
		}
		
                {
			scrollPane = new JScrollPane();
			scrollPane.setEnabled(false);
			scrollPane.setBounds(10, 469, 734, 188);
			contentPane.add(scrollPane);
			{
				tbAlumnos = new JTable();
				tbAlumnos.setEnabled(false);
				tbAlumnos.setFillsViewportHeight(true);
				scrollPane.setViewportView(tbAlumnos);
			}
		}

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnArchivo,
                    mntmCerrarSesin, mntmConctacto, mnVer, mntmVerAlumnos, mntmHistorial, 
                    mntmVerAulas, contentPane, lblUser, lblCode, txtMcod, label_2, txtMnom, 
                    label_3, txtMape, lblTelf, txtMtelf, txtMedad, lblEdad, imgUser, lblRegistroNombre, 
                    txtRegistroNombre, txtRegistroApellidos, txtRegistroEdad, txtRegistroAula, 
                    txtNota1, lblNota1, lblNota2, txtNota2, lblNota3, txtCodAula, txtNota3, 
                    lblRegistroApellidos, lblRegistroEdad, btnRegistrarAlumno, btnGuardarNotas, 
                    btnEliminarAlumno, txtAlumnoCod, lblCodAlumno, lblTitle, lblTitleBar, scrollPane,
                    tbAlumnos, lblAulaCod, cboAulaStatus, lblAulaStatus, btnGuardarAulaStatus,
                    lblAulaUser, label_7, txtMaula, lblHabilitarinhabilitarAula, btnEditarAlumno}));
		try {
	        String queryNom = "select * FROM userIniciado";
	        Statement statement = con.createStatement();
	        ResultSet resultSet = statement.executeQuery(queryNom);
	        if (resultSet.next()) {
                    String codIniciado = resultSet.getString("codIniciado");
	            lblUser.setText("Bienvenido "+resultSet.getString("nombresIniciado")+" "+resultSet.getString("apellidosIniciado"));
                    lblCode.setText("Cod: "+codIniciado);
                    lblTelf.setText("Telf: "+resultSet.getInt("telfIniciado"));
                    lblEdad.setText("Edad: "+resultSet.getInt("edadIniciado"));
                    lblAulaUser.setText("Aula: "+resultSet.getString("aulaIniciado"));
                    if(codIniciado.contains("DOC")){
                        lblCodAlumno.setText("Buscar / Editar Alumno por Código:");
                        lblEdad.setBounds(440, 45, 100, 30);
                        lblAulaUser.setBounds(440, 90, 120, 30);
                        lblCodAlumno.setBounds(10, 320, 270, 25);
                        txtAlumnoCod.setBounds(280, 324, 200, 20);
                        btnGuardarNotas.setBounds(500, 320, 195, 25);
                        lblNota1.setBounds(10, 280, 90, 25);
                        txtNota1.setBounds(80, 280, 50, 25);
                        lblNota2.setBounds(140, 280, 90, 25);
                        txtNota2.setBounds(210, 280, 50, 25);
                        lblNota3.setBounds(270, 280, 90, 25);
                        txtNota3.setBounds(340, 280, 50, 25);
                        txtRegistroNombre.setVisible(false);
                        txtRegistroApellidos.setVisible(false);
                        txtRegistroEdad.setVisible(false);
                        txtCodAula.setVisible(false);
                        btnEditarAlumno.setVisible(false);
                        btnRegistrarAlumno.setVisible(false);
                        cboAulaStatus.setVisible(false);
	    		mntmHistorial.setVisible(false);
                        btnGuardarAulaStatus.setVisible(false);
                        btnEliminarAlumno.setVisible(false);
                        lblRegistroApellidos.setVisible(false);
                        lblRegistroEdad.setVisible(false);
                        lblRegistroNombre.setVisible(false);
                        lblAulaCod.setVisible(false);
                        lblAulaStatus.setVisible(false);
                        lblHabilitarinhabilitarAula.setVisible(false);
                        txtRegistroAula.setVisible(false);
                        lblRegistroAula.setVisible(false);
                        scrollPane.setBounds(10, 360, 734, 200);
                        setBounds(100, 13, 770, 728);
                        this.setBounds(100, 13, 770, 630);
                    }else{
                        lblAulaUser.setVisible(false);
                        txtNota1.setVisible(false);
	    		txtNota2.setVisible(false);
	    		txtNota3.setVisible(false);
	    		txtNota1.setVisible(false);
	    		txtNota2.setVisible(false);
	    		txtNota3.setVisible(false);
	    		btnGuardarNotas.setVisible(false);
                        lblNota1.setVisible(false);
                        lblNota2.setVisible(false);
                        lblNota3.setVisible(false);
                    }
	        }
	        resultSet.close();
	        statement.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
                ListarAl("");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEditarAlumno) {
			do_btnEditar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGuardarAulaStatus) {
			do_btnGuardar_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmVerAulas) {
			do_mntmVerAulas_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmVerAlumnos) {
			do_mntmVerAlumnos_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminarAlumno) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGuardarNotas) {
			do_btnRegistrarN_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnRegistrarAlumno) {
			do_btnRegistrarA_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmHistorial) {
			do_mntmHistorial_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCerrarSesin) {
			do_mntmCerrarSesin_actionPerformed(arg0);
		}
	}
	
	protected void do_mntmCerrarSesin_actionPerformed(ActionEvent arg0) {
		VinicioSesion meCS = new VinicioSesion();
		meCS.setVisible(true);
		this.dispose();
	}
	
	protected void do_mntmHistorial_actionPerformed(ActionEvent arg0) {
		ListarHis();
	}
	
	protected void do_btnRegistrarA_actionPerformed(ActionEvent arg0) {
		if(nombre().isEmpty() || apellido().isEmpty() || txtRegistroEdad.getText().isEmpty() || aula().isEmpty()){
			JOptionPane.showMessageDialog(this, "Por favor llene los campos necesarios: \n Nombre, Apellidos, Edad y Aula");
		}else{
			String ConvalidacionAula = ("Select * from aulas where codAula = '"+aula()+"'");
			try {
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery(ConvalidacionAula);
					if(rs.next()){
						ArrayAlumno registrar = new ArrayAlumno();
						registrar.InsertarAlumno(nombre(), apellido(), edad(), aula());
						ListarAl("");
						JOptionPane.showMessageDialog(this, "Alumno Registrado Correctamente");
						Limpiar();
					} else{
						JOptionPane.showMessageDialog(null, "Ingrese un Código de Aula valido");	
					}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
			}	
		}
	}
	
	protected void do_btnRegistrarN_actionPerformed(ActionEvent arg0) {
		if(N1() > 20 || N1() < 0|| N2() > 20 || N2() < 0 || N3() < 0 ||N3() > 20){
			JOptionPane.showMessageDialog(this, "El rango de nota solo puede ser de 0 a 20");
		}else{
			if(codigo().isEmpty()){
				JOptionPane.showMessageDialog(this, "Por favor ingrese un código de alumno");
			}else{
				ArrayAlumno d_Editar = new ArrayAlumno();
				d_Editar.Docente_EditarAlumno(codigo(), N1(), N2(), N3());
				ListarAl("");
				JOptionPane.showMessageDialog(this, "Notas Editadas Correctamente");
				Limpiar();
			}
		}
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		ArrayAlumno eliminar = new ArrayAlumno();
		if(txtAlumnoCod.getText().isEmpty()){
			JOptionPane.showMessageDialog(this, "Por favor ingrese un código de alumno");
		}else{
			eliminar.EliminarAlumno(txtAlumnoCod.getText());
			ListarAl("");
			JOptionPane.showMessageDialog(this, "Alumno Eliminado Correctamente");
			Limpiar();
		}
	}
	
	protected void do_mntmVerAlumnos_actionPerformed(ActionEvent arg0) {
		ListarAl("");
	}
	
	protected void do_btnGuardar_actionPerformed(ActionEvent arg0) {
		String aaa;
		if(cboAulaStatus.getSelectedIndex() == 0){
			aaa = "HABILITADA";
		}else aaa = "INHABILITADA";
		if(txtCodAula.getText().isEmpty()){
			JOptionPane.showMessageDialog(this, "Por favor ingrese un c�digo de aula");
		}else{
			ArrayAula estadoAU = new ArrayAula();
			estadoAU.CambiarEstado(txtCodAula.getText(), aaa);
			ListarAulas();
			JOptionPane.showMessageDialog(this, "AULA "+aaa);
			txtCodAula.setText("");
		}
	}
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtRegistroEdad) {
			do_txtAedad_keyTyped(e);
		}
		if (e.getSource() == txtRegistroApellidos) {
			do_txtAape_keyTyped(e);
		}
		if (e.getSource() == txtRegistroNombre) {
			do_txtAnom_keyTyped(e);
		}
		if (e.getSource() == txtNota3) {
			do_txtN3_keyTyped(e);
		}
		if (e.getSource() == txtNota2) {
			do_txtN2_keyTyped(e);
		}
		if (e.getSource() == txtNota1) {
			do_txtN1_keyTyped(e);
		}
	}
	protected void do_txtN1_keyTyped(KeyEvent e) {
		char onlynum = e.getKeyChar();
		if(Character.isLetter(onlynum)){
			e.consume();
			JOptionPane.showMessageDialog(null, "Only numbers allowed");
		}
	}
	protected void do_txtN2_keyTyped(KeyEvent e) {
		char onlynum = e.getKeyChar();
		if(Character.isLetter(onlynum)){
			e.consume();
			JOptionPane.showMessageDialog(null, "Only numbers allowed");
		}
	}
	protected void do_txtN3_keyTyped(KeyEvent e) {
		char onlynum = e.getKeyChar();
		if(Character.isLetter(onlynum)){
			e.consume();
			JOptionPane.showMessageDialog(null, "Only numbers allowed");
		}
	}
	protected void do_txtAnom_keyTyped(KeyEvent e) {
		char onlynum = e.getKeyChar();
		if(Character.isDigit(onlynum)){
			e.consume();
			JOptionPane.showMessageDialog(this, "Only letters allowed");
		}
	}
	protected void do_txtAape_keyTyped(KeyEvent e) {
		char onlynum = e.getKeyChar();
		if(Character.isDigit(onlynum)){
			e.consume();
			JOptionPane.showMessageDialog(this, "Only letters allowed");
		}
	}
	protected void do_txtAedad_keyTyped(KeyEvent e) {
		char onlynum = e.getKeyChar();
		if(Character.isLetter(onlynum)){
			e.consume();
			JOptionPane.showMessageDialog(this, "Only numbers allowed");
		}
	}
	
	//------------------------------------------M�todos
	public void ListarAl(String cod){
		DefaultTableModel modelo=new DefaultTableModel();
		ArrayAlumno a=new ArrayAlumno();
		
		ArrayList<Alumno> registro=new ArrayList<Alumno>();
		if(cod.length()==0){
			registro=a.ListarAlumno();
		}
		else
			registro=a.Busqueda(cod);
		modelo.setRowCount(registro.size());
		Iterator<Alumno> it=registro.iterator();
		modelo.addColumn("Cod");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Edad");
		modelo.addColumn("Aula");
		modelo.addColumn("Nota 1");
		modelo.addColumn("Nota 2");
		modelo.addColumn("Nota 3");
		modelo.addColumn("Promedio");
		int i=0;
		while (it.hasNext()) {
			Object obj=it.next();
			Alumno alum=(Alumno)obj;
			modelo.setValueAt(alum.getCodigo(),i,0);
			modelo.setValueAt(alum.getNombre(),i,1);
			modelo.setValueAt(alum.getApellido(),i,2);
			modelo.setValueAt(alum.getEdad(),i,3);
			modelo.setValueAt(alum.getAula(), i, 4);
			modelo.setValueAt(alum.getN1(),i,5);
			modelo.setValueAt(alum.getN2(),i,6);
			modelo.setValueAt(alum.getN3(),i,7);
			modelo.setValueAt(alum.ObtenerPromedio(),i,8);
			i++;
		}
		tbAlumnos.setModel(modelo);
	}
	
	public void ListarHis(){
		DefaultTableModel modelo2 = new DefaultTableModel();
		ArrayHistorial h = new ArrayHistorial();
		
		ArrayList<Historial> lista = new ArrayList<Historial>();
		lista = h.ListarHistorial();
		modelo2.setRowCount(lista.size());
		Iterator<Historial> it2 = lista.iterator();
		modelo2.addColumn("Date");
                modelo2.addColumn("Time");
		modelo2.addColumn("Users Code");
		modelo2.addColumn("Affected Code");
		modelo2.addColumn("Description");
		int x = 0;
		while (it2.hasNext()) {
			Object obj = it2.next();
			Historial histo = (Historial) obj;
			modelo2.setValueAt(histo.getFecha(),x,0);
                        modelo2.setValueAt(histo.getHora(), x, 1);
			modelo2.setValueAt(histo.getCodUsuario(),x,2);
			modelo2.setValueAt(histo.getCodAfectado(),x,3);
			modelo2.setValueAt(histo.getDesc(),x,4);
			x++;
		}
		tbAlumnos.setModel(modelo2);
	}
	public void ListarAulas(){
		DefaultTableModel modelo3 = new DefaultTableModel();
		ArrayAula aa = new ArrayAula();
		
		ArrayList<Aula> lista = new ArrayList<Aula>();
		lista = aa.ListarAula();
		modelo3.setRowCount(lista.size());
		Iterator<Aula> it3 = lista.iterator();
		modelo3.addColumn("Código");
		modelo3.addColumn("Piso");
		modelo3.addColumn("Cantidad de Alumnos");
		modelo3.addColumn("Estado");
		int x = 0;
		while (it3.hasNext()) {
			Object obj = it3.next();
			Aula aula = (Aula) obj;
			modelo3.setValueAt(aula.getCodigoAula(),x,0);
			modelo3.setValueAt(aula.getPiso(),x,1);
			modelo3.setValueAt(aula.getCantidad(),x,2);
			modelo3.setValueAt(aula.getEstado(),x,3);
			x++;
		}
		tbAlumnos.setModel(modelo3);
	}
	
	void Limpiar(){
		txtRegistroNombre.setText("");
                txtRegistroApellidos.setText("");
                txtRegistroAula.setText("");
		txtRegistroEdad.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		txtRegistroAula.setText("");
	}
	
	public String codigo(){
		return txtAlumnoCod.getText();
	}
	public String nombre(){
		return txtRegistroNombre.getText();
	}
	public String apellido(){
		return txtRegistroApellidos.getText();
	}
	public int edad(){
		return Integer.parseInt(txtRegistroEdad.getText());
	}
	public String aula(){
		return txtRegistroAula.getText();
	}
	public double N1(){
		if(txtNota1.getText().isEmpty()){
			return 0.0;
		} return Double.parseDouble(txtNota1.getText());
	}
	public double N2(){
		if(txtNota2.getText().isEmpty()){
			return 0.0;
		} return Double.parseDouble(txtNota2.getText());
	}
	public double N3(){
		if(txtNota3.getText().isEmpty()){
			return 0.0;
		} return Double.parseDouble(txtNota3.getText());
	}
	protected void do_mntmVerAulas_actionPerformed(ActionEvent arg0) {
		ListarAulas();
	}
	protected void do_btnEditar_actionPerformed(ActionEvent arg0) {
		editar.setVisible(true);
	}
}
