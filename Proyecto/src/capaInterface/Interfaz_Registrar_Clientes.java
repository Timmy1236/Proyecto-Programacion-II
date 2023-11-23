package capaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class Interfaz_Registrar_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JButton btnListo;
	private JButton btnCancelar;
	private JLabel lblTipo;
	private JTextField textInmuebles;

	/**
	 * Create the frame.
	 */
	public Interfaz_Registrar_Clientes() {
		setAlwaysOnTop(true);
		setTitle("Registrador de Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cédula de identidad");
		lblCedula.setBounds(45, 14, 127, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(45, 39, 127, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(45, 64, 127, 14);
		contentPane.add(lblApellido);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(45, 111, 127, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(45, 136, 127, 14);
		contentPane.add(lblTelefono);
		
		textCedula = new JTextField();
		textCedula.setBounds(182, 11, 200, 20);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(182, 36, 200, 20);
		contentPane.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(182, 61, 200, 20);
		contentPane.add(textApellido);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(182, 108, 200, 20);
		contentPane.add(textEmail);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(182, 133, 200, 20);
		contentPane.add(textTelefono);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(284, 233, 98, 20);
		contentPane.add(btnCancelar);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(45, 161, 137, 14);
		contentPane.add(lblTipo);
		
		JComboBox comboBoxClienteTipo = new JComboBox();
		comboBoxClienteTipo.setModel(new DefaultComboBoxModel(new String[] {"Dueño", "Comprador/Alquila"}));
		comboBoxClienteTipo.setBounds(182, 157, 200, 22);
		contentPane.add(comboBoxClienteTipo);
		
		JLabel lblInmuebles = new JLabel("Inmuebles");
		lblInmuebles.setBounds(45, 189, 127, 14);
		contentPane.add(lblInmuebles);
		
		textInmuebles = new JTextField();
		textInmuebles.setColumns(10);
		textInmuebles.setBounds(182, 186, 200, 20);
		contentPane.add(textInmuebles);
		
		JLabel lblNewLabel = new JLabel("Separar en comas (1, 2, 3)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(182, 208, 200, 14);
		contentPane.add(lblNewLabel);
		
		JSpinner spinnerAño = new JSpinner();
		spinnerAño.setModel(new SpinnerNumberModel(2000, 1901, 2155, 1));
		spinnerAño.setBounds(182, 85, 54, 20);
		contentPane.add(spinnerAño);
		
		JSpinner spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(264, 85, 45, 20);
		contentPane.add(spinnerMes);
		
		JSpinner spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(337, 85, 45, 20);
		contentPane.add(spinnerDia);
		
		JLabel lblAño = new JLabel("Fecha Nacimiento");
		lblAño.setBounds(45, 89, 98, 14);
		contentPane.add(lblAño);
		
		// NOTE: Esto siempre que quede como ultimo en el codigo, para evitar errores :)
				btnListo = new JButton("Listo");
				btnListo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Agarramos todo los datos de la interfaz y lo pasamos en variable para pasarselo al metodo.
						int cedula = Integer.parseInt(textCedula.getText());
						int telefono = Integer.parseInt(textTelefono.getText());
						
						int año = (int) spinnerAño.getValue();
						int mes = (int) spinnerMes.getValue();
						int dia = (int) spinnerDia.getValue();
						
						String fechaNacimiento = año+"-"+mes+"-"+dia;
								
						String nombre = textNombre.getText();
						String apellido = textApellido.getText();
						String email = textEmail.getText();
						String inmuebles = textInmuebles.getText();
						
						String tipo = (String) comboBoxClienteTipo.getSelectedItem();
						
						// TODO!!: Validar los datos antes de pasarlo.
						MisMetodosDB.registrarCliente(cedula, nombre, apellido, fechaNacimiento, email, telefono, inmuebles, tipo);
						
						// Cerramos la ventana
				        dispose();
					}
				});
				btnListo.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnListo.setBounds(182, 233, 98, 20);
				contentPane.add(btnListo);
	}
}