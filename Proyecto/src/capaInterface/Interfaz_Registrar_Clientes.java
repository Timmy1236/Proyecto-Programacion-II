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
		setTitle("Registrador de Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblEmail.setBounds(45, 89, 127, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(45, 114, 127, 14);
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
		textEmail.setBounds(182, 86, 200, 20);
		contentPane.add(textEmail);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(182, 111, 200, 20);
		contentPane.add(textTelefono);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerramos la ventana
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(284, 211, 98, 42);
		contentPane.add(btnCancelar);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(45, 139, 137, 14);
		contentPane.add(lblTipo);
		
		JComboBox comboBoxClienteTipo = new JComboBox();
		comboBoxClienteTipo.setModel(new DefaultComboBoxModel(new String[] {"Dueño", "Comprador/Alquila"}));
		comboBoxClienteTipo.setBounds(182, 135, 200, 22);
		contentPane.add(comboBoxClienteTipo);
		
		JLabel lblInmuebles = new JLabel("Inmuebles");
		lblInmuebles.setBounds(45, 167, 127, 14);
		contentPane.add(lblInmuebles);
		
		textInmuebles = new JTextField();
		textInmuebles.setColumns(10);
		textInmuebles.setBounds(182, 164, 200, 20);
		contentPane.add(textInmuebles);
		
		JLabel lblNewLabel = new JLabel("Separar en comas (1, 2, 3)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(182, 186, 200, 14);
		contentPane.add(lblNewLabel);
		
		// NOTE: Esto siempre que quede como ultimo en el codigo, para evitar errores :)
		btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agarramos todo los datos de la interfaz y lo pasamos en variable para pasarselo al metodo.
				int cedula = Integer.parseInt(textCedula.getText());
				int telefono = Integer.parseInt(textTelefono.getText());
				
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String email = textEmail.getText();
				String inmuebles = textInmuebles.getText();
				
				String tipo = (String) comboBoxClienteTipo.getSelectedItem();
				
				// TODO!!: Validar los datos antes de pasarlo.
				MisMetodosDB.obtenerDatosRegistroCliente(cedula, nombre, apellido, email, telefono, inmuebles, tipo);
				
				// Cerramos la ventana
		        dispose();
			}
		});
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListo.setBounds(182, 211, 98, 42);
		contentPane.add(btnListo);
	}
}