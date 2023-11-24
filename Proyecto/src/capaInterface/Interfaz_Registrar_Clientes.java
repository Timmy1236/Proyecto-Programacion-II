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
		lblCedula.setBounds(40, 14, 127, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(40, 51, 127, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(40, 133, 127, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(40, 167, 127, 14);
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
		textCedula.setBounds(177, 11, 200, 20);
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
		textNombre.setBounds(177, 48, 200, 20);
		contentPane.add(textNombre);
		
		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarEmail(e);
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(177, 130, 200, 20);
		contentPane.add(textEmail);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones.validarTelefono(e);
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(177, 164, 200, 20);
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
		lblTipo.setBounds(40, 205, 137, 14);
		contentPane.add(lblTipo);
		
		JComboBox comboBoxClienteTipo = new JComboBox();
		comboBoxClienteTipo.setModel(new DefaultComboBoxModel(new String[] {"Dueño", "Comprador/Alquila"}));
		comboBoxClienteTipo.setBounds(177, 201, 200, 22);
		contentPane.add(comboBoxClienteTipo);
		
		JLabel lblInmuebles = new JLabel("Inmuebles");
		lblInmuebles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInmuebles.setBounds(40, 245, 127, 14);
		contentPane.add(lblInmuebles);
		
		textInmuebles = new JTextField();
		textInmuebles.setColumns(10);
		textInmuebles.setBounds(177, 242, 200, 20);
		contentPane.add(textInmuebles);
		
		JSpinner spinnerAño = new JSpinner();
		spinnerAño.setModel(new SpinnerNumberModel(2000, 1901, 2155, 1));
		spinnerAño.setBounds(177, 91, 54, 20);
		contentPane.add(spinnerAño);
		
		JSpinner spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(259, 91, 45, 20);
		contentPane.add(spinnerMes);
		
		JSpinner spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(332, 91, 45, 20);
		contentPane.add(spinnerDia);
		
		JLabel lblAño = new JLabel("Fecha Nacimiento");
		lblAño.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAño.setBounds(40, 95, 127, 14);
		contentPane.add(lblAño);
		
		// NOTE: Esto siempre que quede como ultimo en el codigo, para evitar errores :)
				btnListo = new JButton("Listo");
				btnListo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!Validaciones.vacio(textCedula) && !Validaciones.vacio(textTelefono) && !Validaciones.vacio(textNombre) && !Validaciones.vacio(textEmail) && !Validaciones.vacio(textInmuebles)) {
							if (!MisMetodosDB.existeCliente(Integer.parseInt(textCedula.getText()))) {
								// Agarramos todo los datos de la interfaz y lo pasamos en variable para pasarselo al metodo.
								int cedula = Integer.parseInt(textCedula.getText());
								int telefono = Integer.parseInt(textTelefono.getText());
						
								int año = (int) spinnerAño.getValue();
								int mes = (int) spinnerMes.getValue();
								int dia = (int) spinnerDia.getValue();
						
								String fechaNacimiento = año+"-"+mes+"-"+dia;
								
								String nombreApellido = textNombre.getText();
								String email = textEmail.getText();
								String inmuebles = textInmuebles.getText();
						
								String tipo = (String) comboBoxClienteTipo.getSelectedItem();
						
								MisMetodosDB.registrarCliente(cedula, nombreApellido, fechaNacimiento, email, telefono, inmuebles, tipo);
						
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
				
				JLabel lblNewLabel_1 = new JLabel("(55758216)");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
				lblNewLabel_1.setBounds(387, 14, 140, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_1_4 = new JLabel("(nombre@gmail.com)");
				lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
				lblNewLabel_1_4.setBounds(387, 133, 140, 14);
				contentPane.add(lblNewLabel_1_4);
				
				JLabel lblNewLabel_1_5 = new JLabel("(098729884)");
				lblNewLabel_1_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
				lblNewLabel_1_5.setBounds(387, 167, 140, 14);
				contentPane.add(lblNewLabel_1_5);
				
				JLabel lblNewLabel_1_7 = new JLabel("Seprar en comas (1, 2)");
				lblNewLabel_1_7.setFont(new Font("Tahoma", Font.ITALIC, 11));
				lblNewLabel_1_7.setBounds(387, 245, 140, 14);
				contentPane.add(lblNewLabel_1_7);
	}
}