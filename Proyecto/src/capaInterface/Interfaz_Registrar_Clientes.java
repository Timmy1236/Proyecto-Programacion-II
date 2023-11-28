package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import capaNegocios.MisMetodosDB;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

import capaDatos.Validaciones;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

public class Interfaz_Registrar_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JButton btnListo;
	private JButton btnCancelar;
	private JLabel lblTipo;
	private JTextField textInmuebles;

	// Creamos la interfaz
	public Interfaz_Registrar_Clientes() {
		setAlwaysOnTop(true);
		setTitle("Registrador de Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cédula de identidad");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCedula.setBounds(54, 14, 127, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(54, 51, 127, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(54, 133, 127, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(54, 167, 127, 14);
		contentPane.add(lblTelefono);
		
		textCedula = new JTextField();
		textCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Validamos si las teclas pulsada solamente sean numeros
				Validaciones.validarInt(e);
				// Validamos que no haya mas de 8 caracteres
				if (textCedula.getText().length() >= 8 ) 
	                e.consume();
			}
		});
		textCedula.setBounds(191, 11, 200, 20);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarString(e);
			}
		});
		textNombre.setColumns(10);
		textNombre.setBounds(191, 48, 200, 20);
		contentPane.add(textNombre);
		
		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarEmail(e);
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(191, 130, 200, 20);
		contentPane.add(textEmail);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarTelefono(e);
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(191, 164, 200, 20);
		contentPane.add(textTelefono);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(374, 288, 200, 42);
		contentPane.add(btnCancelar);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(54, 205, 137, 14);
		contentPane.add(lblTipo);
		
		JComboBox comboBoxClienteTipo = new JComboBox();
		comboBoxClienteTipo.setModel(new DefaultComboBoxModel(new String[] {"Dueño", "Comprador/Alquila"}));
		comboBoxClienteTipo.setBounds(191, 201, 200, 22);
		contentPane.add(comboBoxClienteTipo);
		
		JLabel lblInmuebles = new JLabel("Inmuebles");
		lblInmuebles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInmuebles.setBounds(54, 245, 127, 14);
		contentPane.add(lblInmuebles);
		
		textInmuebles = new JTextField();
		textInmuebles.setColumns(10);
		textInmuebles.setBounds(191, 242, 200, 20);
		contentPane.add(textInmuebles);
		
		JLabel lblAño = new JLabel("Fecha Nacimiento");
		lblAño.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAño.setBounds(54, 95, 127, 14);
		contentPane.add(lblAño);
				
		JLabel lblNewLabel_1 = new JLabel("(55758216)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(401, 14, 173, 14);
		contentPane.add(lblNewLabel_1);
				
		JLabel lblNewLabel_1_4 = new JLabel("(nombre@gmail.com)");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1_4.setBounds(401, 133, 173, 14);
		contentPane.add(lblNewLabel_1_4);
				
		JLabel lblNewLabel_1_5 = new JLabel("(098729884)");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1_5.setBounds(401, 167, 173, 14);
		contentPane.add(lblNewLabel_1_5);
				
		JLabel lblNewLabel_1_7 = new JLabel("(Seprar en comas: 1, 2)");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1_7.setBounds(401, 245, 173, 14);
		contentPane.add(lblNewLabel_1_7);
				
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(191, 91, 200, 20);
		contentPane.add(dateChooser);
		
		// NOTE: Esto siempre que quede como ultimo en el codigo, para evitar errores :)
		btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Validaciones.vacio(textCedula) && !Validaciones.vacio(textTelefono) && !Validaciones.vacio(textNombre) && !Validaciones.vacio(textEmail) && !Validaciones.vacio(textInmuebles)) {
					if (!MisMetodosDB.existeCliente(Integer.parseInt(textCedula.getText()))) {
						// Agarramos todo los datos de la interfaz y lo pasamos en variable para pasarselo al metodo.
						int cedula = Integer.parseInt(textCedula.getText());
						int telefono = Integer.parseInt(textTelefono.getText());
						
						Date dateRaw = dateChooser.getDate();
						long time = dateRaw.getTime();
						java.sql.Date fechaNacimiento = new java.sql.Date(time);
						
						String nombreApellido = textNombre.getText();
						String email = textEmail.getText();
						String inmuebles = textInmuebles.getText();
				
						String tipo = (String) comboBoxClienteTipo.getSelectedItem();
				
						MisMetodosDB.subirDatosCliente(cedula, nombreApellido, fechaNacimiento, email, telefono, inmuebles, tipo);
				
						// Cerramos la ventana
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ya existe un cliente con esta cedula.", "Error, cliente duplicado", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListo.setBounds(10, 288, 200, 42);
		contentPane.add(btnListo);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("(Dueño o Comprador/Alquiler)");
		lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1_7_1.setBounds(401, 207, 173, 14);
		contentPane.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("(Jhon Doe)");
		lblNewLabel_1_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1_7_2.setBounds(401, 53, 173, 14);
		contentPane.add(lblNewLabel_1_7_2);
	}
}